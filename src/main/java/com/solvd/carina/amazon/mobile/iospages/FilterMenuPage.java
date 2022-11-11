package com.solvd.carina.amazon.mobile.iospages;

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

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterMenuPageBase.class)
public class FilterMenuPage extends FilterMenuPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//i[@class='nav-sprite hmenu-arrow-more']")
    private ExtendedWebElement seeAllBtn;  //for mobil

    @FindBy(xpath = "//div[text()='Smart Home']")
    private ExtendedWebElement smartHomeBtn;

    @FindBy(xpath = "//a[@class ='hmenu-item'][text()='Pet']")
    private ExtendedWebElement petBtn;

    @FindBy(xpath = "//div[@class ='nav-sprite hmenu-close-icon']")
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
    public FilterMenuPageBase clickSeeAllBtn(){
        return null;
    }

    @Override
    public FilterMenuPageBase clickAmazonMusicBtn() {
        assertElementPresent(smartHomeBtn);
        smartHomeBtn.click();
        waitForJSToLoad();
        return initPage(driver, FilterMenuPageBase.class);
    }

    @Override
    public FilterResultPageBase clickFreeStreamingMusicBtn() {
        assertElementPresent(petBtn);
        petBtn.click();
        waitForJSToLoad();
        return initPage(driver, FilterResultPage.class);
    }

    @Override
    public boolean isFMPageOpen() {
        waitForJSToLoad();
        return closeFilterMenuBtn.isElementPresent() || filterBlock.isElementPresent();
    }

    @Override
    public boolean isAmazonMusicTitlePresent() {
        waitForJSToLoad();
        boolean isSmartHomeTitleDisplayed = smartHomeTitle.isElementPresent();
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
        return initPage(driver, HomePage.class);
    }

    @Override
    public ExtendedWebElement getCloseFilterMenuBtn() {
        return closeFilterMenuBtn;
    }
}
