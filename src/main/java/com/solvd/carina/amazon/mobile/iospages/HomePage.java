package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.constants.Const;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='gwm-dashboard-wrapper']") //browser
    private ExtendedWebElement desktopCardLayout;

    @FindBy(css = "#nav-gwbar")//browser
    private ExtendedWebElement goodDesignLocator;

    @FindBy(xpath = "//a[@id='intlDeals']")//browse
    private ExtendedWebElement todaysDealsLocator;

    public HomePage(WebDriver driver) {
        super(driver);
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
    public boolean isGoodDesire() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(goodDesignLocator.getElement()));
        waitUntil(ExpectedConditions.visibilityOf(goodDesignLocator.getElement()), 5);
        return goodDesignLocator.isElementPresent(5);
    }

}
