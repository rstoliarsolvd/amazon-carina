package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class LocationAlertBase extends AbstractPage {

    public LocationAlertBase(WebDriver driver) {
        super(driver);
    }

    public abstract void verifyAlert();

    public abstract boolean isLocAlertOpen();

    public abstract void closeLocPopUp();
}
