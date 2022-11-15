package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.mobile.base.ResultsPageBase;
import com.solvd.carina.amazon.mobile.base.SignInFormPageBase;
import com.solvd.carina.amazon.mobile.base.UpTabBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = UpTabBase.class)
public class UpTab extends UpTabBase {


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@class='nav-a nav-show-sign-in']")//browser
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//input[@class='nav-input nav-progressive-attribute']")//browser
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")//browser
    private ExtendedWebElement homeBtn;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement uiLoadedMarker;

    @FindBy(xpath = "//input[@type='submit']")//browser
    private ExtendedWebElement searchBtn;


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
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        waitForJSToLoad();
        LOGGER.info("HomePage is opened : " + homePage.isHomePageOpen());
        return initPage(HomePageBase.class);
    }
}