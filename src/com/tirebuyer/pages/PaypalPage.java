package com.tirebuyer.pages;

import com.tirebuyer.automation.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by divi on 8/9/2016.
 */
public class PaypalPage {

    final WebDriver driver;

    @FindBy(xpath = "//*[@id='email']")
    @CacheLookup
    public WebElement email_textbox;

    @FindBy(id = "password")
    @CacheLookup
    public WebElement password_textbox;


    @FindBy(id = "btnLogin")
    @CacheLookup
    public WebElement login_btn;

    @FindBy(xpath = "//*[@id='pageLevelErrors']/ul/li/div")
    @CacheLookup
    public WebElement errortext_label;

    @FindBy(id = "cancelLink")
    @CacheLookup
    public WebElement cancel_and_return_btn;


    public PaypalPage(WebDriver driver)

    {
        this.driver = driver;
    }

    public void loginToPayPal(String email,String pwd)
    {
        GenericMethods.enterTextBoxValue(email_textbox,email);
        GenericMethods.enterTextBoxValue(password_textbox,pwd);
        GenericMethods.click(login_btn);
    }

    public boolean checkForErrorOnPayPalPage(){
        boolean flag=false;
        if(errortext_label.getText().contains("Check your email address and password and try again.")){
            System.out.print("Hello"+errortext_label.getText());
            flag=true;
        }
        return flag;
    }

    public void clickCancelAndReturnButton()
    {
        CheckoutPage checkoutpage = PageFactory.initElements(driver, CheckoutPage.class);
        GenericMethods.click(cancel_and_return_btn);
        checkoutpage.verifyCheckoutPageExistance();
    }

}
