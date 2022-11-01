package com.solvd.carina.amazon.services;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.amazon.mobile.base.HomePageBase;
import com.solvd.carina.amazon.mobile.base.UpTabBase;
import com.solvd.carina.amazon.webpages.HomePage;
import com.solvd.carina.amazon.webpages.UpTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationService {

    /**
     * Back to HomePage
     *
     * @param driver
     * @return
     */
//    public static HomePage goHome(RemoteWebDriver driver) {
//        UpTab upTab = new UpTab(driver);
//        upTab.clickHomeBtn();
//        return new HomePage(driver);
//    }
    public static void goHome(WebDriver driver, UpTabBase aPage) {
        aPage.clickHomeBtn();
    }
}
