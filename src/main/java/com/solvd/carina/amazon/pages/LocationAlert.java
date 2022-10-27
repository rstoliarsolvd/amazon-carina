package com.solvd.carina.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LocationAlert extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(LocationAlert.class);
    public static final String LOCATION_POP_UP_CSS_LOCATOR = ".a-section.glow-toaster.glow-toaster-theme-default.glow-toaster-slot-default.nav-coreFlyout.nav-flyout";


    @FindBy(css = ".a-button.a-spacing-top-base.a-button-base.glow-toaster-button.glow-toaster-button-dismiss")
    private ExtendedWebElement dismissPopUp;

    @FindBy(css = ".a-section.glow-toaster.glow-toaster-theme-default.glow-toaster-slot-default.nav-coreFlyout.nav-flyout")
    private ExtendedWebElement locationPopUp;

    public LocationAlert(RemoteWebDriver driver) {
        super(driver);
    }

    public void verifyAlert() {
        if (!isLocAlertOpen()) {
            LOGGER.info("Location Alert is closed");
        } else {
            closeLocPopUp();
        }
    }

    public boolean isLocAlertOpen() {
        boolean isLocationAlertOpen = locationPopUp.isElementPresent();
        LOGGER.info("Verifying if Location alert is Present - " + isLocationAlertOpen + ". If 'True' - then close it ");
        return isLocationAlertOpen;
    }

    public void closeLocPopUp() {
        dismissPopUp.clickIfPresent();
        if (!isLocAlertOpen()) {
            LOGGER.info("Location Alert closed");
        }
    }
}
