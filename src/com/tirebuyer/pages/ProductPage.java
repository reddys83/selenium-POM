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
public class ProductPage {

    final WebDriver driver;

    @FindBy(xpath = ("//*[@class='addToCart pull-right xs-pull-left ']//a/span[contains(text(),'Add to cart')]"))
    @CacheLookup
    public WebElement addtoCart_btn;

    public ProductPage(WebDriver driver)

    {
        this.driver = driver;
    }

    public void clickonAddtoCartButton()
    {
        CartPage cartpage  = PageFactory.initElements(driver, CartPage.class);
        GenericMethods.click(addtoCart_btn);
        GenericMethods.waitForElementToAppear(driver,cartpage.delivery_to_a_tire_buyer_radio_btn);

    }


}
