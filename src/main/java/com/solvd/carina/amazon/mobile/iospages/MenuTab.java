package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterMenuPageBase;
import com.solvd.carina.amazon.mobile.base.MenuTabBase;
import com.solvd.carina.amazon.mobile.base.TodaysDealPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuTabBase.class)
public class MenuTab extends MenuTabBase {

    @FindBy(xpath = "//a[@id='intlDeals']")//browse
    private ExtendedWebElement todaysDealsBtn;

    @FindBy(xpath = "//i[@class='nav-icon-a11y nav-sprite']")//browse
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
