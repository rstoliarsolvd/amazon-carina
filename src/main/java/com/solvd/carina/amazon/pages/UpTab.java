package com.solvd.carina.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class UpTab extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[@class='a-box-inner a-padding-extra-large']")
    private ExtendedWebElement signInBlock;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private ExtendedWebElement searchBtn;

    public UpTab(RemoteWebDriver driver) {
        super(driver);
    }

    public SignInFormPage clickSignInBtn() {
        signInBtn.clickIfPresent();
        waitForJSToLoad();
        return new SignInFormPage((RemoteWebDriver) driver);
    }

    public void clickSearchField() {
        searchField.clickIfPresent();
    }

    public ResultsPage inputTextInSearchField(String searchItem) {
        searchField.getElement().sendKeys(searchItem, Keys.ENTER);
        return new ResultsPage((RemoteWebDriver) driver);
    }

    /**
     * Another variant of inputTextInSearchField method (without back to selenium methods)
     * @param searchItem
     * @return
     */
//    public ResultsPage inputTextInSearchField(String searchItem) {
//        searchBtn.click();
//        return new ResultsPage((RemoteWebDriver) driver);
//    }

    public ResultsPage findItem(String searchItem) {
        clickSearchField();
        return inputTextInSearchField(searchItem);
    }

    public HomePage clickHomeBtn() {
       homeBtn.click();
        HomePage homePage = new HomePage((RemoteWebDriver) driver);
        waitForJSToLoad();
        LOGGER.info("HomePage is opened : " + homePage.isHomePageOpen());
        return homePage;
    }
}