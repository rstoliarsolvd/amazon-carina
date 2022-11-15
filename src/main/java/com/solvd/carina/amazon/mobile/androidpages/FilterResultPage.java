package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.FilterResultPageBase;
import com.solvd.carina.amazon.services.CheckMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterResultPageBase.class)
public class FilterResultPage extends FilterResultPageBase {

    public static final Logger LOGGER = Logger.getLogger(FilterResultPage.class);

    @FindBy(xpath = "//div[@class='padding-top-xlarge padding-bottom-mini flex-container flex-align-items-stretch flex-align-content-flex-start flex-full-width music ember']")//browser
    private ExtendedWebElement freeStreamingMusicTitle;


    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private List<ExtendedWebElement> goodsOfFilter;

    public FilterResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitleOnFilterResultPageWithFreeStreamingMusic() {
        boolean isTitleFreeStreamingDisplayed = freeStreamingMusicTitle.isElementPresent();
        LOGGER.info("Verifying if title with 'Free Streaming music' Present. : " + isTitleFreeStreamingDisplayed);
        return isTitleFreeStreamingDisplayed;
    }

    @Override
    public List<String> getGoodsTitlesList() {
        return goodsOfFilter.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean areAllGoodsTitleContainsSearchItem(String pet) {
        List<String> goodsText = getGoodsTitlesList();
        boolean isStringPetPresentInGoodsList = CheckMethods.isStringPresentInList(goodsText, pet);
        LOGGER.info("Verifying if " + pet + " Present in all goods : " + isStringPetPresentInGoodsList);
        return isStringPetPresentInGoodsList;
    }
}
