package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterMenuPageBase;
import com.solvd.carina.amazon.mobile.base.FilterResultPageBase;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterMenuPageBase.class)
public class FilterMenuPage extends FilterMenuPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    //    @FindBy(xpath = "//i[@class='nav-sprite hmenu-arrow-more']")
    @FindBy(xpath = "//div[@id=\"hmenu-content\"]/ul[1]/li[12]/a[1]/div")
    private ExtendedWebElement seeAllBtn;  //for mobil

    @FindBy(xpath = "//div[text()='Smart Home']")
    private ExtendedWebElement smartHomeBtn;

    @FindBy(xpath = "//div[@id=\"hmenu-content\"]/ul[1]/ul/li[3]/a/div")
    private ExtendedWebElement amazonMusicBtn;
    @FindBy(xpath = "//div[@id=\"hmenu-content\"]/ul[2]/li[2]/div")
    private ExtendedWebElement amazonMusicTitle;
    @FindBy(xpath = "//*[@href='/music/free?ref_=navm_em__dm_nav_nw_0_2_2_2']")
    private ExtendedWebElement freeStreamingMusicBtn;
    @FindBy(xpath = "//*[contains(@class,'color-black font_Sharp_Grotesk_Pan_Euro_Bold_20 mobilePortrait align-center')]")
    private ExtendedWebElement freeStreamingMusicTitle;


    @FindBy(xpath = "//a[@class ='hmenu-item'][text()='Pet']")
    private ExtendedWebElement petBtn;

    //    @FindBy(xpath = "//div[@class ='nav-sprite hmenu-close-icon']")
    @FindBy(xpath = "//a[@id=\"hmenu-close-menu\"]")
    private ExtendedWebElement closeFilterMenuBtn;

    //    @FindBy(xpath = "//*[@id='hmenu-content']") // the same locator but upper and wider (needed depends on page design)
    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']")
    private ExtendedWebElement filterBlock;

    @FindBy(xpath = "//*[@id='hmenu-content']//following::div[contains(text(),'smart home')]")
    private ExtendedWebElement smartHomeTitle;

    @FindBy(xpath = "//*[text()='Smart Pet | Smart Home']")
    private ExtendedWebElement titleSmartPet;

    public FilterMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilterMenuPageBase clickSeeAllBtn() {
        seeAllBtn.click();
        return initPage(driver, FilterMenuPageBase.class);
    }

    @Override
    public FilterMenuPageBase clickAmazonMusicBtn() {
        assertElementPresent(amazonMusicBtn);
        amazonMusicBtn.click();
        waitForJSToLoad();
        return initPage(driver, FilterMenuPageBase.class);
    }

    @Override
    public FilterResultPageBase clickFreeStreamingMusicBtn() {
        waitForJSToLoad();
        pause(3);
        assertElementPresent(freeStreamingMusicBtn);
        freeStreamingMusicBtn.click();
        waitForJSToLoad();
        return initPage(driver, FilterResultPageBase.class);
    }

    @Override
    public boolean isFMPageOpen() {
        waitForJSToLoad();
        return closeFilterMenuBtn.isElementPresent() || filterBlock.isElementPresent();
    }

    @Override
    public boolean isAmazonMusicTitlePresent() {
        waitForJSToLoad();
        boolean isSmartHomeTitleDisplayed = amazonMusicTitle.isElementPresent();
        LOGGER.info("Verifying 'Smart Home' Presence on title of page : " + isSmartHomeTitleDisplayed);
        return isSmartHomeTitleDisplayed;
    }

    @Override
    public HomePageBase clickCloseBtn() {
        waitForJSToLoad();
        closeFilterMenuBtn.click();
        boolean isCloseFilterMenuBtnDisplayed = closeFilterMenuBtn.isElementPresent();
        waitForJSToLoad();
        LOGGER.info("closeFilterMenuBtn disappeared after clicking on it - " + !isCloseFilterMenuBtnDisplayed);
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public ExtendedWebElement getCloseFilterMenuBtn() {
        return closeFilterMenuBtn;
    }
}
