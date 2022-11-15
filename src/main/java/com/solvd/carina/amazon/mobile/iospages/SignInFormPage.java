package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.constants.Const;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.mobile.base.SignInFormPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignInFormPageBase.class)
public class SignInFormPage extends SignInFormPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//div[@id='outer-accordion-signin-signup-page']/h2")//browse
    private ExtendedWebElement header;

    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")//browse
    private ExtendedWebElement homeBtn;

    private String titleName = "Welcome";
    private String textName = "Create an account";

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHeaderSignIn() {

        String headerText = header.getText();

        boolean isHeaderGood = header.getText().contains(textName) || header.getText().contains(titleName);
        LOGGER.info("Verifying the header of window (that is - " + headerText + ") have title - 'Welcome' . This is - " + isHeaderGood);
        return isHeaderGood;
    }

    @Override
    public void clickHomeBtn() {
        if (homeBtn.isElementPresent()) {
            homeBtn.click();
        }
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        waitUntil(ExpectedConditions.urlToBe(Const.HOME_LOGO_URL), 5);
        LOGGER.info("click Home-Btn. And HomePage is open - " + homePage.isPageOpened());
    }
}
