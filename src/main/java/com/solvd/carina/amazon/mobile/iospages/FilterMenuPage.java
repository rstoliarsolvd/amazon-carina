package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterMenuPageBase;
import com.solvd.carina.amazon.mobile.base.FilterResultPageBase;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterMenuPageBase.class)
public class FilterMenuPage extends FilterMenuPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@class='hmenu-item hmenu-compressed-btn']/div")//browser
    private ExtendedWebElement seeAllBtn;

    @FindBy(xpath = "//a[@class='hmenu-item'][@data-ref-tag='navm_em_1_1_1_9']/div")//browser
    private ExtendedWebElement amazonMusicBtn;

    @FindBy(xpath = "//div[text()='amazon music']")//browser
    private ExtendedWebElement amazonMusicTitle;

    @FindBy(xpath = "//a[@href='/music/free?ref_=navm_em__dm_nav_nw_0_2_2_2']")//browser
    private ExtendedWebElement freeStreamingMusicBtn;

//    @FindBy(xpath = "//h3[@class='color-black font_Sharp_Grotesk_Pan_Euro_Bold_20 mobilePortrait align-center']")//browser
//    @FindBy(xpath = "//div[@class='padding-left-xmini padding-right-xmini padding-top-xmini padding-bottom-xmini flex-container flex-align-items-stretch flex-align-content-flex-start flex-full-width music ember']")
    @FindBy(xpath = "//div[contains(@class,'padding-left-xmini padding-right-xmini')]")
    private ExtendedWebElement freeStreamingMusicTitle;

    @FindBy(xpath = "//div[@class='nav-sprite hmenu-close-icon']")//browser
    private ExtendedWebElement closeFilterMenuBtn;

    //    @FindBy(xpath = "//*[@id='hmenu-content']") // the same locator but upper and wider (needed depends on page design)
    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']")
    private ExtendedWebElement filterBlock;

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
        waitUntil(ExpectedConditions.invisibilityOf(amazonMusicBtn.getElement()),5);
        return initPage(driver, FilterMenuPageBase.class);
    }

    @Override
    public FilterResultPageBase clickFreeStreamingMusicBtn() {
        waitUntil(ExpectedConditions.visibilityOf(freeStreamingMusicBtn.getElement()),5);
        assertElementPresent(freeStreamingMusicBtn);
        freeStreamingMusicBtn.click();
        waitUntil(ExpectedConditions.visibilityOf(freeStreamingMusicTitle.getElement()), 5);
        return initPage(driver, FilterResultPageBase.class);
    }

    @Override
    public boolean isFMPageOpen() {
        waitForJSToLoad();
        return closeFilterMenuBtn.isElementPresent() || filterBlock.isElementPresent();
    }

    @Override
    public boolean isAmazonMusicTitlePresent() {
        waitUntil(ExpectedConditions.visibilityOf(amazonMusicTitle.getElement()),5);
        boolean isSmartHomeTitleDisplayed = amazonMusicTitle.isElementPresent();
        LOGGER.info("Verifying 'Smart Home' Presence on title of page : " + isSmartHomeTitleDisplayed);
        return isSmartHomeTitleDisplayed;
    }

    @Override
    public HomePageBase clickCloseBtn() {
        waitUntil(ExpectedConditions.visibilityOf(closeFilterMenuBtn.getElement()),5);
        closeFilterMenuBtn.click();
        waitUntil(ExpectedConditions.invisibilityOf(closeFilterMenuBtn.getElement()),5);
        boolean isCloseFilterMenuBtnDisplayed = closeFilterMenuBtn.isElementPresent();
        LOGGER.info("closeFilterMenuBtn disappeared after clicking on it - " + !isCloseFilterMenuBtnDisplayed);
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public ExtendedWebElement getCloseFilterMenuBtn() {
        return closeFilterMenuBtn;
    }
}