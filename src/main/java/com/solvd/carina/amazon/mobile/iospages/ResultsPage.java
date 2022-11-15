package com.solvd.carina.amazon.mobile.iospages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.mobile.base.ResultsPageBase;
import com.solvd.carina.amazon.services.CheckMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ResultsPageBase.class)
public class ResultsPage extends ResultsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@class='a-size-small a-color-base a-text-normal']")//browser
    private List<ExtendedWebElement> goodsResult;

    @FindBy(xpath = "//div[@class='a-section a-spacing-none s-title-instructions-style']")//browser
    private List<ExtendedWebElement> goodsResult1;

    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']")//browser
    private List<ExtendedWebElement> goodsResult2;

    @FindBy(xpath = "//div[@class='s-no-outline']/span[text()='RESULTS']")//browser
    private ExtendedWebElement resultPageTitle;


    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> goodsTitles() {
        waitUntil(ExpectedConditions.visibilityOf( resultPageTitle.getElement()),5);
        List<String> titles = goodsResult2.stream()
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
