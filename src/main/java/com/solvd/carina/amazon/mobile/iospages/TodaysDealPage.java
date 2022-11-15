package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
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

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TodaysDealPageBase.class)
public class TodaysDealPage extends TodaysDealPageBase {

    private static final Logger LOGGER = Logger.getLogger(TodaysDealPage.class);
    public static final String LOCATOR_GOODS_DISC = "//*[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']//div[contains(@class,'DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN')]";

    @FindBy(xpath = "//h1")
    private ExtendedWebElement header;

    @FindBy(xpath = "//*[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']//div[contains(@class,'DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN')]")
    private List<ExtendedWebElement> discountGoods;

    @FindBy(xpath = "//div[@aria-label='Watch now']")
    private ExtendedWebElement watchNow;

    @FindBy(xpath = "//div[@aria-label='Watch now']")
    private ExtendedWebElement uiLoaderMarker;

    public TodaysDealPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoaderMarker);
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
        return discountGoods.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean areGoodsHaveDiscount() {
        List<String> discGoods = goodsTitleDiscountsList();
        List<String> discounts = new ArrayList<>(Arrays.asList("up", "%", "off", "under", "-"));
        boolean areTheseGoodsOnDiscounts = CheckMethods.isElementsPresentInList(discGoods, 8, discounts);
        LOGGER.info("Verifying that all goods have at least one feature of discount: " + areTheseGoodsOnDiscounts);
        return areTheseGoodsOnDiscounts;
    }
}
