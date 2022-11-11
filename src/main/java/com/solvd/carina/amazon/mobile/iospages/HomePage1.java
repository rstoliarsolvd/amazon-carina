package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.constants.Const;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage1 extends HomePageBase {

    public HomePage1(WebDriver driver) {
        super(driver);
        setPageURL(Const.HOME_URL);
    }

    @Override
    public boolean isHomePageOpen() {
        return false;
    }

//    @Override
//    public ExtendedWebElement getHomePageWebElement() {
//        return null;
//    }

    @Override
    public boolean isGoodDesire() {
        return false;
    }
}
