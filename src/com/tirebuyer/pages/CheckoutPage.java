package com.tirebuyer.pages;

import com.tirebuyer.automation.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by divi on 8/9/2016.
 */
public class CheckoutPage {

    final WebDriver driver;

    @FindBy(xpath = ("//*[@id='paypal-payment']/a/img"))
    @CacheLookup
    public WebElement checkout_with_paypal_btn;

    public CheckoutPage(WebDriver driver)

    {
        this.driver = driver;
    }

    public void clickOnCheckoutWithPayPalButton()
    {
        GenericMethods.click(checkout_with_paypal_btn);

    }

    public void verifyCheckoutPageExistance()
    {
     Assert.assertTrue(GenericMethods.verifyWebElementDisplayOnAPage(checkout_with_paypal_btn));
    }

}
