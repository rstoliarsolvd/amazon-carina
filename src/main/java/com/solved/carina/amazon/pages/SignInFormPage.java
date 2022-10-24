package com.solved.carina.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInFormPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(SignInFormPage.class);

    @FindBy(xpath = "//h1")
    private ExtendedWebElement header;

    @FindBy(xpath = "//a[@class='a-link-nav-icon']")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//*[@aria-label='Amazon']")
    private ExtendedWebElement homeBtn1;

    private String titleName = "Sign in";

    public SignInFormPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        HomePage homePage = new HomePage((RemoteWebDriver) driver);
        waitForJSToLoad();
        LOGGER.info("click Home-Btn. And HomePage is open - " + homePage.isHomePageOpen());

    }
}
