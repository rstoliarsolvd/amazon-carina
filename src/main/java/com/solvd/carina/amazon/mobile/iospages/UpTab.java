package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.mobile.base.ResultsPageBase;
import com.solvd.carina.amazon.mobile.base.SignInFormPageBase;
import com.solvd.carina.amazon.mobile.base.UpTabBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = UpTabBase.class)
public class UpTab extends UpTabBase {

    private static final Logger LOGGER = Logger.getLogger(UpTab.class);

//    @FindBy(id = "nav-link-accountList-nav-line-1")
    @FindBy(xpath = "//android.view.View[@content-desc=\"Sign in ›\"]")
//    @FindBy(xpath = "//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView")
//    @FindBy(xpath = "//div[@id=\"nav-progressive-greeting\"]")
    private ExtendedWebElement signInBtn;

//    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear search keywords\"]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[@class='a-box-inner a-padding-extra-large']")
    private ExtendedWebElement signInBlock;

//    @FindBy(id = "nav-logo-sprites")
    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement homeBtn;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement uiLoadedMarker;

//    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[@resource-id=\"outer-accordion-signin-signup-page\"]/android.view.View[1]")
    private ExtendedWebElement headerSign;

    public UpTab(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoadedMarker);
    }

    @Override
    public SignInFormPageBase clickSignInBtn() {
        signInBtn.clickIfPresent();
        waitForJSToLoad();
        waitUntil(ExpectedConditions.visibilityOf(headerSign.getElement()),5);
        return initPage(driver, SignInFormPageBase.class);
    }

    @Override
    public void clickSearchField() {
        searchField.clickIfPresent();
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
        HomePageBase homePage = initPage(driver, HomePage.class);
        waitForJSToLoad();
        LOGGER.info("HomePage is opened : " + homePage.isHomePageOpen());
        return initPage(HomePageBase.class);
    }
}