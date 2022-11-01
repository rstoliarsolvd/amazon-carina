package com.solvd.carina.amazon;


import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.amazon.constants.Const;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AbstractTest {

    /**
     * For Selenium Standalone server //for parallel ran (multiThread)
     */
    protected static ThreadLocal<RemoteWebDriver> driverT = new ThreadLocal<>();

    /**
     * For Selenium server
     */
//    public WebDriver driver;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    /**
     * For setting needed driver
     * @param browser  - //    @Parameters({"browser"}) - used here to have possibility to use browsers specified in .xml(suit) as parameter
     * @throws Exception
     */
//    @Parameters({"browser"})
//    @BeforeMethod
    protected static void setupDriver(String browser) throws Exception {

        PropertyConfigurator.configure(Const.LOG4J_CONF_PATH);

/**
 * For Selenium Standalone server
 */
        RemoteWebDriver driver = null;

        DesiredCapabilities cap = new DesiredCapabilities();
        Configuration.get(Configuration.Parameter.BROWSER);

        if (browser.equals("chrome")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
            options.merge(cap);
        } else if (browser.equals("firefox")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("firefox");
            FirefoxOptions options = new FirefoxOptions();
            options.merge(cap);
        } else if (browser.equals("safari")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("safari");
            SafariOptions options = new SafariOptions();
            options.merge(cap);
        } else {
            System.out.println("Nothing");
        }
        driver = new RemoteWebDriver(new URL(Const.LOCAL_HOST), cap);
//         ((AndroidDriver<?>) driver).activateApp("com.android.chrome");


/**
 * For Selenium Standalone server and for Selenium  server
 */
//        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/IdeaProjects/chromedriver");
//        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Const.HOME_URL);
        LOGGER.info("Start tests");
        driverT.set(driver);
    }


    /**
     * Taking screenshot method
     *
     * @param result
     */
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driverT.get();
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                /**
                 * This block needed only for not re-writing screenshots
                 */
//                Date currentDate = new Date();
//                String dataStr = currentDate.toString().replace(" ", "_").replace(":", "-");
//                FileUtils.copyFile(src, new File(Const.SCREEN_SHOT_PATH + result.getName() + dataStr + ".png"));
                FileUtils.copyFile(src, new File(Const.SCREEN_SHOT_PATH + result.getName() + "-" + driverT.get().getCapabilities().getBrowserName() + ".png"));
                LOGGER.info("Successfully captured a screenshot");
            } catch (Exception e) {
                LOGGER.info("Exception while taking screenshot " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    public void setUpCloseAndScreenshotFail(ITestResult result) {
        screenShot(result);
        finishSetup();
    }


    public void finishSetup() {
        LOGGER.info("Tests finished");
        if (driverT.get() != null) {
            driverT.get().quit();
            driverT.set(null);
        }
    }


    /**
     * This block is just for one thread standalone use
     */
//    public static RemoteWebDriver getDriver(){
//        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//        try {
//             driver = new RemoteWebDriver(new URL(Const.HOME_URL), options);
//        } catch (MalformedURLException e) {
//            LOGGER.info("Invalid grid URL");
//        } catch (Exception e) {
//            LOGGER.info(e.getMessage());
//        }
//        return driver;
//    }
    public void refreshPageIfWrongDesign(RemoteWebDriver driver, boolean isGoodDesire) {
        if (!isGoodDesire) {
            driver.navigate().refresh();
        }
    }
}
