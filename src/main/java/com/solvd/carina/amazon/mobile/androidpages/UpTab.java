package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.mobile.base.ResultsPageBase;
import com.solvd.carina.amazon.mobile.base.SignInFormPageBase;
import com.solvd.carina.amazon.mobile.base.UpTabBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UpTabBase.class)
public class UpTab extends UpTabBase {

    private static final Logger LOGGER = Logger.getLogger(UpTab.class);


@FindBy(xpath = "//div[@id='nav-progressive-greeting']")
private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//*[@id='nav-search-keywords']")
    private ExtendedWebElement searchField;

 @FindBy(xpath = "//input[@nav-input nav-progressive-attribute']")
    private ExtendedWebElement searchField1;

    @FindBy(xpath = "//div[@class='a-box-inner a-padding-extra-large']")
    private ExtendedWebElement signInBlock;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement homeBtn;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement uiLoadedMarker;

    @FindBy(xpath = "//form[@id='nav-search-form']//*[@type='submit']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[@resource-id=\"outer-accordion-signin-signup-page\"]/android.view.View[1]")
    private ExtendedWebElement headerSign;

    public UpTab(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoadedMarker);
    }

    @Override
    public SignInFormPageBase clickSignInBtn() {

        signInBtn.click();
        waitForJSToLoad();
        return initPage(driver, SignInFormPageBase.class);
    }

    @Override
    public void clickSearchField() {
//        searchField.clickIfPresent();
        searchField.click();
    }

    @Override
    public ResultsPageBase inputTextInSearchField(String searchItem) {
        searchField.getElement().sendKeys(searchItem, Keys.ENTER);
        return initPage(driver, ResultsPageBase.class);
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
        HomePageBase homePage = initPage(driver,HomePageBase.class);
        waitForJSToLoad();
        LOGGER.info("HomePage is opened : " + homePage.isHomePageOpen());
        return initPage(HomePageBase.class);
    }
}