package com.solvd.carina.amazon.webpages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class UpTab extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    private ExtendedWebElement uiLoadedMarker;

    @FindBy(xpath = "//div[@class='a-box-inner a-padding-extra-large']")
    private ExtendedWebElement signInBlock;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private ExtendedWebElement searchBtn;

    public UpTab(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoadedMarker);
    }

    public SignInFormPage clickSignInBtn() {
        signInBtn.clickIfPresent();
        waitForJSToLoad();
        return new SignInFormPage(driver);
    }

    public void clickSearchField() {
        searchField.clickIfPresent();
    }

    public ResultsPage inputTextInSearchField(String searchItem) {
        searchField.getElement().sendKeys(searchItem, Keys.ENTER);
        return new ResultsPage(driver);
    }

    /**
     * Another variant of inputTextInSearchField method (without back to selenium methods)
     * @param searchItem
     * @return
     */
//    public ResultsPage inputTextInSearchField(String searchItem) {
//       searchField.sendKeys(Keys.valueOf(searchItem));
//       searchBtn.click();
//       return new ResultsPage(driver);
//    }

    public ResultsPage findItem(String searchItem) {
        clickSearchField();
        return inputTextInSearchField(searchItem);
    }

    public HomePage clickHomeBtn() {
       homeBtn.click();
        HomePage homePage = new HomePage(driver);
        waitForJSToLoad();
        LOGGER.info("HomePage is opened : " + homePage.isPageOpened());
        return homePage;
    }
}