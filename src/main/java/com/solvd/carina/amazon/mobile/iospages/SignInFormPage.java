package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.SignInFormPageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignInFormPageBase.class)
public class SignInFormPage extends SignInFormPageBase {

    private static final Logger LOGGER = Logger.getLogger(SignInFormPage.class);

//    @FindBy(xpath = "//h2")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]2")
    private ExtendedWebElement header;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Create an account\"]/android.widget.TextView")
    private ExtendedWebElement header1;

//    @FindBy(xpath = "//a[@class='a-link-nav-icon']")
//    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")  //for mobil
    @FindBy(xpath = "//android.view.View[@content-desc=\"Amazon\"]")
    private ExtendedWebElement homeBtn;

//    @FindBy(xpath = "//*[@aria-label='Amazon']")
    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")  //for mobil
    private ExtendedWebElement homeBtn1;

//    private String titleName = "Sign in";
    private String titleName = "Welcome";
    private String textName = "Create an account";

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHeaderSignIn() {
        String headerText = header.getText();
        boolean isHeaderGood = headerText.equals(titleName) || header1.getText().equals(textName);
        LOGGER.info("Verifying the header of window (that is - " + headerText + ") have title - 'Welcome' . This is - " + isHeaderGood);
        return isHeaderGood;
    }

    @Override
    public void clickHomeBtn() {
        if (homeBtn.isPresent()) {
            homeBtn.click();}
        HomePage homePage = initPage(driver, HomePage.class);
        waitForJSToLoad();
        LOGGER.info("click Home-Btn. And HomePage is open - " + homePage.isPageOpened());
    }
}
