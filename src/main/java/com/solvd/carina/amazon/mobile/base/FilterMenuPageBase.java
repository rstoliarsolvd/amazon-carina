package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterMenuPageBase extends AbstractPage {


    public FilterMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FilterMenuPageBase clickSeeAllBtn();

    public abstract FilterMenuPageBase clickAmazonMusicBtn();

    public abstract FilterResultPageBase clickFreeStreamingMusicBtn();

    public abstract boolean isFMPageOpen();

    public abstract boolean isAmazonMusicTitlePresent();

    public abstract HomePageBase clickCloseBtn();

    public abstract ExtendedWebElement getCloseFilterMenuBtn();
}