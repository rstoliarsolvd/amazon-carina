package com.solvd.carina.amazon.webpages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.amazon.services.CheckMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[contains(@class, 's-main-slot')]//*[contains(@class, 's-title-instructions-style')]")
    private List<ExtendedWebElement> goodsResult;

    @FindBy(xpath = "//span[@data-component-id='13']")
    private ExtendedWebElement uiLoadedMarker;

    public ResultsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(uiLoadedMarker);
    }

    public List<String> goodsTitles() {
        waitForJSToLoad();
        List<String> titles = goodsResult.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
        return titles;
    }

    public boolean areTitlesContainsItem(String input) {
        String[] str = input.split(" ");
        List<String> titles = goodsTitles();
        boolean areElsContainsEls = CheckMethods.areAllElementsContainAllElements(titles, str);
        LOGGER.info("Verifying all goods have in their title - " + input + " : " + areElsContainsEls);
        return areElsContainsEls;
    }
}
