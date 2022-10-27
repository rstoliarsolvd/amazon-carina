package com.solvd.carina.amazon.services;

import com.solvd.carina.amazon.pages.HomePage;
import com.solvd.carina.amazon.pages.UpTab;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationService {

    /**
     * Back to HomePage
     *
     * @param driver
     * @return
     */
    public static HomePage goHome(RemoteWebDriver driver) {
        UpTab upTab = new UpTab(driver);
        upTab.clickHomeBtn();
        return new HomePage(driver);
    }
}
