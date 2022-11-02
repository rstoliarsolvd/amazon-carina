package com.solvd.carina.amazon.webpages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SignInFormPage extends AbstractPage {

private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1")
    private ExtendedWebElement header;

    @FindBy(xpath = "//a[@class='a-link-nav-icon']")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//*[@aria-label='Amazon']")
    private ExtendedWebElement homeBtn1;

    private String titleName = "Sign in";

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderSignIn() {
        String headerText = header.getText();
        boolean isHeaderGood = headerText.equals(titleName);
        LOGGER.info("Verifying the header of window (that is - " + headerText + ") have title - 'Sign in' . This is - " + isHeaderGood);
        return isHeaderGood;
    }

    public void clickHomeBtn() {
        if (homeBtn.isPresent()) {
            homeBtn.click();
        } else if (homeBtn1.isPresent()) {
            homeBtn1.click();
        }
        HomePage homePage = new HomePage( driver);
        waitForJSToLoad();
        LOGGER.info("click Home-Btn. And HomePage is open - " + homePage.isHomePageOpen());

    }
}
