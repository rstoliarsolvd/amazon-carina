package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.constants.Const;
import com.solvd.carina.amazon.mobile.base.TodaysDealPageBase;
import com.solvd.carina.amazon.services.CheckMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TodaysDealPageBase.class)
public class TodaysDealPage extends TodaysDealPageBase implements IMobileUtils {

    private static final Logger LOGGER = Logger.getLogger(TodaysDealPage.class);
    public static final String LOCATOR_GOODS_DISC = "//*[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']//div[contains(@class,'DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN')]";

    @FindBy(xpath = "//h1")
    private ExtendedWebElement header;

//    //    @FindBy(xpath = "//*[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']//div[contains(@class,'DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN')]")
//    @FindBy(xpath = "//android.view.View[@resource-id='slot-15']//android.view.View")
//    private List<ExtendedWebElement> discountGoods1;
//    @FindBy(xpath = "//div[@id=\"slot-15\"]//a/div[1]/div")
//    private List<ExtendedWebElement> discountGoods2;
//    @FindBy(xpath = "(//div[@id=\"slot-15\"])[2]//div[1]/div/div/a/div/a/div[2]/div")
//    private List<ExtendedWebElement> discountGoods3;
//    @FindBy(xpath = "((//div[@id=\"slot-15\"])[2]/div/div/div[3]//a/div/div[2]/a/div[2]/div")
//    private List<ExtendedWebElement> discountGoods4;
    @FindBy(xpath = "//*[contains(@class,'DealCard')]")
    private List<ExtendedWebElement> discountGoods;

    @FindBy(xpath = "//div[@aria-label='Watch now']")
    private ExtendedWebElement watchNow;

    @FindBy(xpath = "//div[@aria-label='Watch now']")
    private ExtendedWebElement uiLoaderMarker;

    public TodaysDealPage(WebDriver driver) {
        super(driver);
//        setUiLoadedMarker(uiLoaderMarker);
        setPageURL(Const.TODAYS_URL);
    }

    @Override
    public boolean areGoodWithDealsPresent() {
        boolean areGoodDealsPresent = driver.findElements(By.xpath(LOCATOR_GOODS_DISC)).size() > 1;
        LOGGER.info("Verify if goods with deals discounts present on the page: " + areGoodDealsPresent);
        return areGoodDealsPresent;
    }

    @Override
    public boolean ifTDPageIsOpen() {
        waitForJSToLoad();
        return areGoodsHaveDiscount();
    }

    @Override
    public List<String> goodsTitleDiscountsList() {
        swipeUpScreen();

        return discountGoods.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public void swipeUpScreen() {
        int h = driver.manage().window().getSize().getHeight();
        int w = driver.manage().window().getSize().getWidth();
        int x1 = w / 2;
        int x2 = x1;
        int y1 = h / 5 * 4;
        int y2 = h / 5;
        swipe(x1, y1, x2, y2, 5);
    }

    @Override
    public boolean areGoodsHaveDiscount() {
        List<String> discGoods = goodsTitleDiscountsList();
        List<String> discounts = new ArrayList<>(Arrays.asList("up", "%", "off", "under", "-"));
        boolean areTheseGoodsOnDiscounts = CheckMethods.isElementsPresentInList(discGoods, 4, discounts);
        LOGGER.info("Verifying that all goods have at least one feature of discount: " + areTheseGoodsOnDiscounts);
        return areTheseGoodsOnDiscounts;
    }
}
