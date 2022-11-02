package com.solvd.carina.amazon;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.amazon.constants.Const;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.lang.invoke.MethodHandles;


public class AbstractWebTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    /**
     * Taking screenshot method
     *
     * @param result
     */
    public void screenShot(ITestResult result, WebDriver driver) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                /**
                 * This block needed only for not re-writing screenshots
                 */
//                Date currentDate = new Date();
//                String dataStr = currentDate.toString().replace(" ", "_").replace(":", "-");
//                FileUtils.copyFile(src, new File(Const.SCREEN_SHOT_PATH + result.getName() + dataStr + ".png"));
                FileUtils.copyFile(src, new File(Const.SCREEN_SHOT_PATH + result.getName() + "-" + ((HasCapabilities) getDriver()).getCapabilities().getBrowserName() + ".png"));
                LOGGER.info("Successfully captured a screenshot");
            } catch (Exception e) {
                LOGGER.info("Exception while taking screenshot " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    public void setUpCloseAndScreenshotFail(ITestResult result) {
        WebDriver driver = getDriver();
        screenShot(result, driver);
    }

    public void refreshPageIfWrongDesign(WebDriver driver, boolean isGoodDesire) {
        if (!isGoodDesire) {
            driver.navigate().refresh();
        }
    }

}
