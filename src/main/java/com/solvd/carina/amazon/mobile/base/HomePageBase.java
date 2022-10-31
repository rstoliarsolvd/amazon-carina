package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;


public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(RemoteWebDriver driver) {
        super(driver);
    }

    public abstract boolean isHomePageOpen();

    public abstract ExtendedWebElement getHomePageWebElement();
}
