package com.solvd.carina.amazon;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * This is Simple Test carina tests.
 *
 * @author
 */
//public class SimpleTest extends AbstractMobilTest implements IAbstractTest{
public class SimpleTest implements IAbstractTest{

        private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

        @Test(description = "Verify if note appeared to check if build succeed")
        @MethodOwner(owner = "rstoliar", platform = "web")
        @TestPriority(Priority.P1)
        @TestLabel(name = "feature", value = {"web", "regression"})
        public void simpleTestMessage() throws Exception {

            //Driver initialisation (default)
//            String browser = Configuration.getBrowser();
//            AbstractTest.setupDriver(browser);

            //output the OK-message
            LOGGER.info("!!!!!!!! This is simple test to check if build!!!!!!!!!!");
//            R.CONFIG.put("capabilities.browserName", "firefox", true);
            getDriver();
        }
}
