package com.solved.carina.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solved.carina.amazon.constants.Const;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@id='desktop-banner-stripe']")
    private ExtendedWebElement desktopBannerStripe;

    @FindBy(xpath = "//div[@id='gw-card-layout']")
    private ExtendedWebElement desktopCardLayout;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageOpen() {
        waitForJSToLoad();
        FilterMenuPage filterMenuPage = new FilterMenuPage((RemoteWebDriver) driver);
        boolean isHomePageOpened = driver.getCurrentUrl().equals(Const.HOME_URL)
                || driver.getCurrentUrl().equals(Const.HOME_LOGO_URL)
                || desktopCardLayout.isElementPresent();
        LOGGER.info("Verifying Home-page is opened: " + isHomePageOpened);
        return isHomePageOpened;
    }

    public ExtendedWebElement getHomePageWebElement() {
        return desktopCardLayout;
    }
}
