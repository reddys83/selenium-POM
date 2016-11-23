package com.tirebuyer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.tirebuyer.automation.GenericMethods;
import com.tirebuyer.pages.ResultsPage;
/**
 * Created by divi on 8/9/2016.
 */
public class HomePage {

    final WebDriver driver;

    @FindBy(xpath = ("//*[@id='formFitment']//select[@name='year']"))
    @CacheLookup
    private WebElement year_Dropdown;

    @FindBy(xpath = ("//*[@id='formFitment']//select[@name='make']"))
    @CacheLookup
    private WebElement make_Dropdown;

    @FindBy(xpath = ("//*[@id='formFitment']//select[@name='model']"))
    @CacheLookup
    private WebElement model_Dropdown;

    @FindBy(xpath = ("//*[@id='formFitment']//select[@name='trim']"))
    @CacheLookup
    private WebElement style_Dropdown;

    @FindBy(xpath = ("//*[@id='formFitment']//input[@name='zipCode']"))
    @CacheLookup
    private WebElement zipcode_TextBox;

    @FindBy(xpath = ("//*[@id='formFitment']//div[@class='col-xs-6']"))
    @CacheLookup
    private WebElement shoptires_Btn;



    public HomePage(WebDriver driver)

    {
        this.driver = driver;
    }

    public ResultsPage searchForATire(String year,String make, String model,String trim,String zipcode)
    {
        ResultsPage rp = PageFactory.initElements(driver, ResultsPage.class);
        GenericMethods.selectAnItemFromDropdown(year_Dropdown,year);
        GenericMethods.selectAnItemFromDropdown(make_Dropdown,make);
        GenericMethods.selectAnItemFromDropdown(model_Dropdown,model);
        GenericMethods.selectAnItemFromDropdown(style_Dropdown,trim);
        GenericMethods.enterTextBoxValue(zipcode_TextBox,zipcode);
        GenericMethods.click(shoptires_Btn);
        GenericMethods.waitForElementToAppear(driver,rp.results_label);
        GenericMethods.waitForElementToAppear(driver,rp.moreDetails_links.get(0));
        return new ResultsPage(driver);
    }


}
