package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterMenuPageBase;
import com.solvd.carina.amazon.mobile.base.MenuTabBase;
import com.solvd.carina.amazon.mobile.base.TodaysDealPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuTabBase.class)
public class MenuTab extends MenuTabBase {

//    @FindBy(xpath = "//*[@id='nav-xshop']//a[1]")   // for web
//    @FindBy(xpath = "//*[@id='intlDeals']")  //for mobil
    @FindBy(xpath = "//android.view.View[@content-desc=\"Deals\"]/android.widget.TextView")
    private ExtendedWebElement todaysDealsBtn;

//    @FindBy(xpath = "//*[@class='hm-icon nav-sprite']")    // for web
//    @FindBy(xpath = "//i[@class='nav-icon-a11y nav-sprite']")  //for mobil
    @FindBy(id = "nav-hamburger-menu")
    private ExtendedWebElement filterMenuBtn;

    @FindBy(xpath = "//i[@class='nav-icon-a11y nav-sprite']")
    private ExtendedWebElement uiLoadedMarker;

    public MenuTab(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoadedMarker);
    }

    @Override
    public FilterMenuPageBase clickFilterMenuBtn() {
        filterMenuBtn.click();
        waitForJSToLoad();
        pause(3);
        return initPage(driver, FilterMenuPageBase.class);
    }

    @Override
    public TodaysDealPageBase clickTodaysDealsBtn() {
        todaysDealsBtn.clickIfPresent();
        return initPage(driver, TodaysDealPageBase.class);
    }
}
