package com.solvd.carina.amazon.webpages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.amazon.constants.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FilterMenuPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[text()='Smart Home']")
    private ExtendedWebElement smartHomeBtn;

    @FindBy(xpath = "//a[@class ='hmenu-item'][text()='Pet']")
    private ExtendedWebElement petBtn;

    @FindBy(xpath = "//div[@class ='nav-sprite hmenu-close-icon']")
    private ExtendedWebElement closeFilterMenuBtn;

    @FindBy(xpath = "//div[@class ='nav-sprite hmenu-close-icon']")
    private ExtendedWebElement uiLoaderMarker;

    //    @FindBy(xpath = "//*[@id='hmenu-content']") // the same locator but upper and wider (needed depends on page design)
    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']")
    private ExtendedWebElement filterBlock;

    @FindBy(xpath = "//*[@id='hmenu-content']//following::div[contains(text(),'smart home')]")
    private ExtendedWebElement smartHomeTitle;

    @FindBy(xpath = "//*[text()='Smart Pet | Smart Home']")
    private ExtendedWebElement titleSmartPet;

    public FilterMenuPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoaderMarker);
        setPageURL(Const.HOME_LOGO_URL);
    }

    public FilterMenuPage clickSmartHomeBtn() {
        assertElementPresent(smartHomeBtn);
        smartHomeBtn.click();
        waitForJSToLoad();
        return new FilterMenuPage(driver);
    }

    public FilterResultPage clickPetBtn() {
        assertElementPresent(petBtn);
        petBtn.click();
        waitForJSToLoad();
        return new FilterResultPage(driver);

    }

    public boolean isSmartTitlePresent() {
        waitForJSToLoad();
        boolean isSmartHomeTitleDisplayed = smartHomeTitle.isElementPresent();
        LOGGER.info("Verifying 'Smart Home' Presence on title of page : " + isSmartHomeTitleDisplayed);
        return isSmartHomeTitleDisplayed;
    }

    public HomePage clickCloseBtn() {
        waitForJSToLoad();
        closeFilterMenuBtn.click();
        boolean isCloseFilterMenuBtnDisplayed = closeFilterMenuBtn.isElementPresent();
        waitForJSToLoad();
        LOGGER.info("closeFilterMenuBtn disappeared after clicking on it - " + !isCloseFilterMenuBtnDisplayed);
        return new HomePage(driver);
    }

    public ExtendedWebElement getCloseFilterMenuBtn() {
        return closeFilterMenuBtn;
    }
}
