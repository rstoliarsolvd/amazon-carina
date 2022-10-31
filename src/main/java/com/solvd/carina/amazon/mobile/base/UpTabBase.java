package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class UpTabBase extends AbstractPage {

    public UpTabBase(RemoteWebDriver driver) {
        super(driver);
    }

    public abstract SignInFormPageBase clickSignInBtn();

    public abstract void clickSearchField();

    public abstract ResultsPageBase inputTextInSearchField(String searchItem);

    public abstract ResultsPageBase findItem(String searchItem);

    public abstract HomePageBase clickHomeBtn();

}