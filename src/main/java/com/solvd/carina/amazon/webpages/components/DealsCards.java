package com.solvd.carina.amazon.webpages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DealsCards extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='BadgeAutomated-module__badgeOneLineContainer_yYupgq1lKxb5h3bfDqA-B'] //time[@class ='DealMessaging-module__dealMessaging_1EIwT6BUaB6vCKvPVEbAEV']")
    private ExtendedWebElement goodsCard;

    public DealsCards(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
