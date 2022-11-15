package com.solvd.carina.amazon.webpages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MenuTab extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//*[@id='nav-xshop']//a[1]")
    private ExtendedWebElement todaysDealsBtn;

    @FindBy(xpath = "//*[@class='hm-icon nav-sprite']")
    private ExtendedWebElement filterMenuBtn;

    public MenuTab(WebDriver driver) {
        super(driver);
    }

    public FilterMenuPage clickFilterMenuBtn() {
        filterMenuBtn.clickIfPresent();
        return new FilterMenuPage( driver);
    }

    public TodaysDealPage clickTodaysDealsBtn() {
       todaysDealsBtn.clickIfPresent();
        return new TodaysDealPage(driver);
    }
}
