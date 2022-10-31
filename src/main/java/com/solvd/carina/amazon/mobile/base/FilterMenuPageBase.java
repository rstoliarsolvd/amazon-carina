package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class FilterMenuPageBase extends AbstractPage {


    public FilterMenuPageBase(RemoteWebDriver driver) {
        super(driver);
    }

    public abstract FilterMenuPageBase clickSmartHomeBtn();

    public abstract FilterResultPageBase clickPetBtn();

    public abstract boolean isFMPageOpen();

    public abstract boolean isSmartTitlePresent();

    public abstract HomePageBase clickCloseBtn();

    public abstract ExtendedWebElement getCloseFilterMenuBtn();
}