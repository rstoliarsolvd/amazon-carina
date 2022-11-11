package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterMenuPageBase;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.constants.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id='gwm-Deck-cf']")   //for mobil
    private ExtendedWebElement desktopCardLayout;

//    @FindBy(xpath = "//header[@id=\"nav-main\"]")
    @FindBy(xpath = "//div[@id=\"gwm-dashboard\"]")
    private ExtendedWebElement goodDesignLocator;

    @FindBy(xpath = "//a[@id=\"intlDeals\"]")
    private ExtendedWebElement todaysDealsLocator;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Deals\"]/android.widget.TextView")
    private ExtendedWebElement todaysDealsLocator1;

    //    @FindBy(xpath = "//*[@id='nav-main']")
    @FindBy(xpath = "//div[@id=\"nav-gwbar\"]")
    private ExtendedWebElement uiLoaderMarker;

    public HomePage(WebDriver driver) {
        super(driver);
//        setUiLoadedMarker(uiLoaderMarker);
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

//    @Override
//    public ExtendedWebElement getHomePageWebElement() {
//        return desktopCardLayout;
//    }

    @Override
    public boolean isGoodDesire(){

        new WebDriverWait(getDriver(),5).until(ExpectedConditions.visibilityOf(goodDesignLocator.getElement()));
        waitUntil(ExpectedConditions.visibilityOf(goodDesignLocator.getElement()), 5);
        return goodDesignLocator.isElementPresent(5);
    }

}
