package com.solvd.carina.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.amazon.services.CheckMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class FilterResultPage extends AbstractPage {

    public static final Logger LOGGER = Logger.getLogger(FilterResultPage.class);

    @FindBy(xpath = "//*[text()='Smart Pet | Smart Home']")
    private ExtendedWebElement titleSmartPet;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private List<ExtendedWebElement> goodsOfFilter;

    public FilterResultPage(RemoteWebDriver driver) {
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
