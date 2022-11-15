package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.MenuTabBase;
import com.solvd.carina.amazon.mobile.base.TodaysDealPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuTabBase.class)
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
    public FilterMenuPage clickFilterMenuBtn() {
        filterMenuBtn.clickIfPresent();
        return initPage(driver, FilterMenuPage.class);
    }

    @Override
    public TodaysDealPageBase clickTodaysDealsBtn() {
        todaysDealsBtn.clickIfPresent();
        return initPage(driver, TodaysDealPageBase.class);
    }
}
