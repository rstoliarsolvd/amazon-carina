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

public class FilterResultPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[text()='Smart Pet | Smart Home']")
    private ExtendedWebElement titleSmartPet;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private List<ExtendedWebElement> goodsOfFilter;

    public FilterResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOnFilterResultPageWithPet() {
        boolean isTitleSmartPetDisplayed = titleSmartPet.isPresent();
        LOGGER.info("Verifying if title with 'Smart Home' and 'Pet' Present. : " + isTitleSmartPetDisplayed);
        return isTitleSmartPetDisplayed;
    }

    public List<String> getGoodsTitlesList() {
        return goodsOfFilter.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean areAllGoodsTitleContainsSearchItem(String pet) {
        List<String> goodsText = getGoodsTitlesList();
        boolean isStringPetPresentInGoodsList = CheckMethods.isStringPresentInList(goodsText, pet);
        LOGGER.info("Verifying if " + pet + " Present in all goods : " + isStringPetPresentInGoodsList);
        return isStringPetPresentInGoodsList;
    }
}
