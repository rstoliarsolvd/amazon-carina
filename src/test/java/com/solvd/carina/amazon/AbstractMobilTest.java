package com.solvd.carina.amazon;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.openqa.selenium.WebDriver;

public class AbstractMobilTest implements IAbstractTest {

    public void refreshPageIfWrongDesign(WebDriver driver, boolean isGoodDesire) {
        if (!isGoodDesire) {
            driver.navigate().refresh();
        }
    }
}
