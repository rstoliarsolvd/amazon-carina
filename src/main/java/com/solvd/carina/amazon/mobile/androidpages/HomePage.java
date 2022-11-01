package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterMenuPageBase;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.constants.Const;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@id='desktop-banner-stripe']")
    private ExtendedWebElement desktopBannerStripe;

    @FindBy(xpath = "//div[@id='gw-card-layout']")
    private ExtendedWebElement desktopCardLayout;

    @FindBy(xpath = "//*[@id='nav-main']")
    private ExtendedWebElement goodDesignLocator;

    @FindBy(xpath = "//*[@id='nav-main']")
    private ExtendedWebElement uiLoaderMarker;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoaderMarker);
        setPageURL(Configuration.get(Configuration.Parameter.URL));
    }

    @Override
    public boolean isHomePageOpen() {
        waitForJSToLoad();
        boolean isHomePageOpened = driver.getCurrentUrl().equals(Const.HOME_URL)
                || driver.getCurrentUrl().equals(Const.HOME_LOGO_URL)
                || desktopCardLayout.isElementPresent();
        LOGGER.info("Verifying Home-page is opened: " + isHomePageOpened);
        return isHomePageOpened;
    }

    @Override
    public ExtendedWebElement getHomePageWebElement() {
        return desktopCardLayout;
    }

    @Override
    public boolean isGoodDesire(){
        return goodDesignLocator.isElementPresent(5);
    }

}
