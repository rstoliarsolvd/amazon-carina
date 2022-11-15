package com.solvd.carina.amazon.mobile.androidpages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.ResultsPageBase;
import com.solvd.carina.amazon.services.CheckMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultsPageBase.class)
public class ResultsPage extends ResultsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@class='a-size-small a-color-base a-text-normal']")//browser
    private List<ExtendedWebElement> goodsResult;


    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> goodsTitles() {

        waitForJSToLoad();
        List<String> titles = goodsResult.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
        return titles;
    }

    @Override
    public boolean areTitlesContainsItem(String input) {
        String[] str = input.split(" ");
        List<String> titles = goodsTitles();
        boolean areElsContainsEls = CheckMethods.areAllElementsContainAllElements(titles, str);
        LOGGER.info("Verifying all goods have in their title - " + input + " : " + areElsContainsEls);
        return areElsContainsEls;
    }
}
