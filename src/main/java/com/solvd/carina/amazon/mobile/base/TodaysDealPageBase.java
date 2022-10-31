package com.solvd.carina.amazon.mobile.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public abstract class TodaysDealPageBase extends AbstractPage {

    public TodaysDealPageBase(RemoteWebDriver driver) {
        super(driver);
    }

    public abstract boolean areGoodWithDealsPresent();

    public abstract boolean ifTDPageIsOpen();

    public abstract List<String> goodsTitleDiscountsList();

    public abstract boolean areGoodsHaveDiscount();
}
