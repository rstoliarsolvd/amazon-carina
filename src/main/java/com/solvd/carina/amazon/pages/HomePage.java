package com.solvd.carina.amazon.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@id='desktop-banner-stripe']")
    private ExtendedWebElement desktopBannerStripe;

    @FindBy(xpath = "//div[@id='gw-card-layout']")
    private ExtendedWebElement desktopCardLayout;

    @FindBy(xpath = "//*[@id='nav-main']")
    ExtendedWebElement goodDesignLocator;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isHomePageOpen() {
        waitForJSToLoad();
        FilterMenuPage filterMenuPage = new FilterMenuPage((RemoteWebDriver) driver);
        boolean isHomePageOpened = driver.getCurrentUrl().equals(R.CONFIG.get("url"))
                || driver.getCurrentUrl().equals(R.CONFIG.get("url_logo"))
                || desktopCardLayout.isElementPresent();
        LOGGER.info("Verifying Home-page is opened: " + isHomePageOpened);
        return isHomePageOpened;
    }

    public ExtendedWebElement getHomePageWebElement() {
        return desktopCardLayout;
    }

    public boolean isGoodDesire(){
        return goodDesignLocator.isElementPresent(5);
    }
}