package com.solvd.carina.amazon.services;

import com.solvd.carina.amazon.webpages.HomePage;
import com.solvd.carina.amazon.webpages.UpTab;
import org.openqa.selenium.WebDriver;

public class NavigationServiceWeb {

        /**
         * Back to HomePage
         *
         * @param driver
         * @return
         */
    public static HomePage goHome(WebDriver driver) {
        UpTab upTab = new UpTab(driver);
        upTab.clickHomeBtn();
        return new HomePage(driver);
    }
}
