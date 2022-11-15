package com.solvd.carina.amazon.services;

import com.qaprosoft.carina.core.foundation.utils.common.CommonUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class ServiceForStartTestOnIos {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void launchApp() {
        LOGGER.info("Starting " + "com.apple.mobilesafari");
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobilesafari");
        getIOSDriver().executeScript("mobile: launchApp", params);
        LOGGER.info("Script was executed. Waiting...");
        CommonUtils.pause(3);
    }

    public IOSDriver<?> getIOSDriver() {
        WebDriver drv = getDriver();
        if (drv instanceof EventFiringWebDriver) {
            drv = ((EventFiringWebDriver) drv).getWrappedDriver();
        }
        return (IOSDriver<?>) drv;
    }
}
