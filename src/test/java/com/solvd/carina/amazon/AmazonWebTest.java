package com.solvd.carina.amazon;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.solvd.carina.amazon.services.NavigationServiceWeb;
import com.solvd.carina.amazon.utils.RetryTestRunAttempts;
import com.solvd.carina.amazon.webpages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.log4j.Logger;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AmazonWebTest extends AbstractWebTest {

    private static final Logger LOGGER = Logger.getLogger(com.solvd.carina.amazon.AmazonWebTest.class);


    @DataProvider(name = "browser")
    public Object[][] browser() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}};
    }

    //    @TestRailCases(testCasesId = "111", suiteId = "N1")
    @Test(dataProvider = "browser",
            description = "Verify if 'SignIn'-form appeared after 'SignIn'-button click on UpTab")
    @MethodOwner(owner = "rstoliar", platform = "web")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void verifySignInFormAppearedTest(String browser) {

        /**
         * Next raw for run test on different browsers taken from DataProvider
         */
//        R.CONFIG.put(Configuration.Parameter.BROWSER.getKey(), browser, true);//not the best way
        R.CONFIG.put("capabilities.browserName", browser, true);
        //Driver initialisation (all from dataProvider)
        WebDriver driver = getDriver(browser);

        //Output info about thread number and browser name
        LOGGER.info("verifySignInFormAppearedTest Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + ((HasCapabilities) getDriver()).getCapabilities().getBrowserName());

        //get driver and verify good page design. If not - then refresh
        HomePage homePage = new HomePage(driver);
        homePage.open();

        refreshPageIfWrongDesign(driver, homePage.isGoodDesire());

        //press on signIn btn and verify signIn page is open
        UpTab upTab = new UpTab(driver);

        SignInFormPage signInFormPage = upTab.clickSignInBtn();
        Assert.assertTrue(signInFormPage.isHeaderSignIn(), "Header on opened page is not 'Sign in'");

        //back to home page
        signInFormPage.clickHomeBtn();
    }

    @DataProvider(name = "searchItem")
    public Object[][] searchItem() {
        return new Object[][]{{"iphone 11 case"}};
    }

    //    @TestRailCases(testCasesId = "112", suiteId = "N1")
    @Test(dataProvider = "searchItem",
            description = "Verify name of search item written in search field present in all goods provided after search")
    @MethodOwner(owner = "rstoliar", platform = "web")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void verifySearchFieldAndHomeBtn(String searchItem) {

        /**
         * Next raw for run test on another browser (firefox)
         */
//        R.CONFIG.put(Configuration.Parameter.BROWSER.getKey(), "firefox", true);
        R.CONFIG.put("capabilities.browserName", "firefox", true);

        //Driver initialisation
        WebDriver driver = getDriver();

        //Output info about thread number and browser name
        LOGGER.info("verifySearchFieldAndHomeBtn Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + ((HasCapabilities) getDriver()).getCapabilities().getBrowserName());

        //get driver and verify good page design. If not - then refresh
        HomePage homePage = new HomePage(driver);
        homePage.open();
        refreshPageIfWrongDesign(driver, homePage.isGoodDesire());

        //Input searched good and verify result for it
        UpTab upTab = new UpTab(driver);
//        ResultsPage resultsPage = upTab.findItem(searchItem);
        ResultsPage resultsPage = upTab.findItem("tree");
        Assert.assertTrue(resultsPage.areTitlesContainsItem(searchItem), "Not all goods titles contains searched items");
        Screenshot.capture(homePage.getDriver(), "Screenshot capture!");

        //back to home page and verify that home page is open
        homePage = NavigationServiceWeb.goHome(driver);
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
    }

    //    @Test(retryAnalyzer = RetryTestRunAttempts.class)
//    @TestRailCases(testCasesId = "113", suiteId = "N1")
    @Test(description = "Verify all goods provided after press 'TodaysDeals'-button have discount",
            retryAnalyzer = RetryTestRunAttempts.class)
    @MethodOwner(owner = "rstoliar", platform = "web")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void verifyTodayDealsOption() {

        /**
         * Next raw for run test on another browser (firefox)
         */
//        R.CONFIG.put(Configuration.Parameter.BROWSER.getKey(), "firefox", true);
//        R.CONFIG.put("capabilities.browserName", "firefox", true); //the best


        //Driver initialisation
        WebDriver driver = getDriver();

        //Output info about thread number and browser name
        LOGGER.info("verifyTodayDealsOption Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + ((HasCapabilities) getDriver()).getCapabilities().getBrowserName());

        //get driver and verify good page design. If not - then refresh
        HomePage homePage = new HomePage(driver);
        homePage.open();
        refreshPageIfWrongDesign(driver, homePage.isGoodDesire());

        //Verify LocationAlert. If it is presented, then close it.
        LocationAlert lAlert = new LocationAlert(driver);

        lAlert.verifyAlert();

        //Press TodaysDeals and verify all goods have discounts on opened page
        MenuTab menuTab = new MenuTab(driver);

        TodaysDealPage todaysDealPage = menuTab.clickTodaysDealsBtn();
        Assert.assertTrue(todaysDealPage.ifTDPageIsOpen(), "No Today's Deals page is open");
        Assert.assertTrue(todaysDealPage.areGoodsHaveDiscount(), "Not All goods have discounts");

        //back to home page
        NavigationServiceWeb.goHome(driver);
    }

    //    @TestRailCases(testCasesId = "114", suiteId = "N1")
    @Test(dataProvider = "browser",
            description = "Verify all goods provided after choosing filter options are have attitude to position we were seeking"
//            , retryAnalyzer = RetryTestRunAttempts.class
    )
    @MethodOwner(owner = "rstoliar", platform = "web")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void verifyFilterTest(String browser) {
        /**
         * Next raw for run test on different browsers taken from DataProvider
         */
//        R.CONFIG.put(Configuration.Parameter.BROWSER.getKey(), browser, true);
        R.CONFIG.put("capabilities.browserName", browser, true);//the best

        //Driver initialisation (all from dataProvider)
        WebDriver driver = getDriver(browser);

        //Output info about thread number and browser name
        LOGGER.info("verifyFilterTest Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + ((HasCapabilities) getDriver()).getCapabilities().getBrowserName());

        String pet = "pet";

        //get driver and verify good page design. If not - then refresh
        HomePage homePage = new HomePage(driver);
        homePage.open();
        refreshPageIfWrongDesign(driver, homePage.isGoodDesire());

        //Open filter capabilities
        MenuTab menuTab = new MenuTab(driver);
        FilterMenuPage filterMenuPage = menuTab.clickFilterMenuBtn();

        //Choose position of first level filter menu and verify its name present in title on appeared second level filter menu(or result page)
        filterMenuPage = filterMenuPage.clickSmartHomeBtn();
        Assert.assertTrue(filterMenuPage.isFMPageOpen(), "Filter menu page is not open");
        Assert.assertTrue(filterMenuPage.isSmartTitlePresent(), "Filter menu page do not contain the needed title of menu block");

        //Choose position of second level filter menu and verify its name present in title on appeared result page
        FilterResultPage filterResultPage = filterMenuPage.clickPetBtn();
        Assert.assertTrue(filterResultPage.isTitleOnFilterResultPageWithPet(), " No 'Pet' title is displayed");
        Assert.assertTrue(filterResultPage.areAllGoodsTitleContainsSearchItem(pet), "No 'Pet' in title on filter result page present");

        //back to home page
        NavigationServiceWeb.goHome(driver);
    }

    //    @TestRailCases(testCasesId = "115", suiteId = "N1")
    @Test(dataProvider = "browser",
            description = "Verify that after press 'Close'-button on choosing filter options, all filter options are closed and Home-page is open",
            retryAnalyzer = RetryTestRunAttempts.class)
    @MethodOwner(owner = "rstoliar", platform = "web")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})

    public void verifyFilterMenuCloseBtn(String browser) {

        /**
         * Next raw for run test on different browsers taken from DataProvider
         */
        R.CONFIG.put(Configuration.Parameter.BROWSER.getKey(), browser, true);

        //Driver initialisation (all from dataProvider)
        WebDriver driver = getDriver();

        //Output info about thread number and browser name
        LOGGER.info("verifyFilterMenuCloseBtn Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + ((HasCapabilities) getDriver()).getCapabilities().getBrowserName());

        //get driver and verify good page design. If not - then refresh
        HomePage homePage = new HomePage(driver);
        homePage.open();
        refreshPageIfWrongDesign(driver, homePage.isGoodDesire());

        //Open filter capabilities and verify that filter capabilities are shown
        MenuTab menuTab = new MenuTab(driver);
        FilterMenuPage filterMenuPage = menuTab.clickFilterMenuBtn();
        Assert.assertTrue(filterMenuPage.isFMPageOpen(), "Filter menu page is not open");

        //Close filter page and back to home page. Verify home page is open
        homePage = filterMenuPage.clickCloseBtn();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not open");
    }
}
