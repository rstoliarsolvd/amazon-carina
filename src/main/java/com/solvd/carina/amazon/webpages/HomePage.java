package com.solvd.carina.amazon.webpages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.amazon.constants.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static com.solvd.carina.amazon.constants.Const.HOME_LOGO_URL;
import static com.solvd.carina.amazon.constants.Const.HOME_URL;


public class HomePage extends AbstractPage {

private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id='desktop-banner-stripe']")
    private ExtendedWebElement desktopBannerStripe;

    @FindBy(xpath = "//div[@id='gw-card-layout']")
    private ExtendedWebElement desktopCardLayout;

    @FindBy(xpath = "//*[@id='nav-main']")
    ExtendedWebElement goodDesignLocator;

    @FindBy(xpath = "//*[@id='nav-main']")
    ExtendedWebElement uiLoadedMarker;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoadedMarker);
        setPageURL(HOME_URL);
        setPageURL(HOME_LOGO_URL);
    }

    public ExtendedWebElement getHomePageWebElement() {
        return desktopCardLayout;
    }

    public boolean isGoodDesire(){
        return goodDesignLocator.isElementPresent(5);
    }
}
