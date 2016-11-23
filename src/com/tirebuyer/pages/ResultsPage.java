package com.tirebuyer.pages;

import com.tirebuyer.automation.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by divi on 8/9/2016.
 */
public class ResultsPage {

    final WebDriver driver;

    @FindBy(xpath = ("//*[@id='main']//li[@class='active' and text()='Tire Results']"))
    @CacheLookup
    public WebElement results_label;

    @FindBy(xpath = ("//*[@id='main']//a[text()='More details']"))
    @CacheLookup
    public List<WebElement> moreDetails_links;

    public ResultsPage(WebDriver driver)

    {
        this.driver = driver;
    }

    public void clickOnMoreResultsLinkByProductRowNumber(int rownumber)
    {
        ProductPage productpage = PageFactory.initElements(driver, ProductPage.class);
        GenericMethods.click(moreDetails_links.get(rownumber-1));
        GenericMethods.waitForElementToAppear(driver,productpage.addtoCart_btn);
    }


}
