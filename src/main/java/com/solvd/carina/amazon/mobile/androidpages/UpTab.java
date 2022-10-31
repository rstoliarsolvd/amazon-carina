package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.mobile.base.ResultsPageBase;
import com.solvd.carina.amazon.mobile.base.SignInFormPageBase;
import com.solvd.carina.amazon.mobile.base.UpTabBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UpTabBase.class)
public class UpTab extends UpTabBase {

    private static final Logger LOGGER = Logger.getLogger(UpTab.class);

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

    @Override
    public SignInFormPageBase clickSignInBtn() {
        signInBtn.clickIfPresent();
        waitForJSToLoad();
        return new SignInFormPage((RemoteWebDriver) driver);
    }

    @Override
    public void clickSearchField() {
        searchField.clickIfPresent();
    }

    @Override
    public ResultsPageBase inputTextInSearchField(String searchItem) {
        searchField.getElement().sendKeys(searchItem, Keys.ENTER);
        return initPage(driver, ResultsPage.class);
    }

    /**
     * Another variant of inputTextInSearchField method (without back to selenium methods)
     *
     * @param searchItem
     * @return
     */
//    @Override
//    public ResultsPageBase inputTextInSearchField(String searchItem) {
//        searchField.sendKeys(Keys.valueOf(searchItem));
//        searchBtn.click();
//        return initPage(driver, ResultsPage.class);
//    }

    @Override
    public ResultsPageBase findItem(String searchItem) {
        clickSearchField();
        return inputTextInSearchField(searchItem);
    }

    @Override
    public HomePageBase clickHomeBtn() {
        homeBtn.click();
        HomePageBase homePage = new HomePage((RemoteWebDriver) driver);
        waitForJSToLoad();
        LOGGER.info("HomePage is opened : " + homePage.isHomePageOpen());
        return initPage(HomePageBase.class);
    }
}