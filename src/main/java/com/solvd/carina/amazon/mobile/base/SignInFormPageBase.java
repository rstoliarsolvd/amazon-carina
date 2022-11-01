package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class SignInFormPageBase extends AbstractPage {

    public SignInFormPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isHeaderSignIn();

    public abstract void clickHomeBtn();
}
