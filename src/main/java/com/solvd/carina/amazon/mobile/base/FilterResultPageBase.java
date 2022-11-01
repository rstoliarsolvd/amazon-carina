package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public abstract class FilterResultPageBase extends AbstractPage {

    public FilterResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitleOnFilterResultPageWithPet();

    public abstract List<String> getGoodsTitlesList();

    public abstract boolean areAllGoodsTitleContainsSearchItem(String pet);
}
