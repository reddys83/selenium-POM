package com.tirebuyer.tests;
import com.tirebuyer.automation.PropertiesReader;
import com.tirebuyer.pages.CartPage;
import com.tirebuyer.pages.ProductPage;
import com.tirebuyer.pages.ResultsPage;
import com.tirebuyer.pages.CheckoutPage;
import com.tirebuyer.pages.PaypalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import com.tirebuyer.pages.HomePage;
/**
 * Created by divi on 8/9/2016.
 */
public class CheckoutTest {
 static WebDriver driver;

 @BeforeSuite()
 public void setupDriver(){
     PropertiesReader prop=new PropertiesReader();
    driver = new FirefoxDriver();
     driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(prop.getProperty("AppURL"));



 }
 @Test()
 public void checkOutTest(){
     HomePage homepage  = PageFactory.initElements(driver, HomePage.class);
     ResultsPage resultspage  = PageFactory.initElements(driver, ResultsPage.class);
     ProductPage productpage  = PageFactory.initElements(driver, ProductPage.class);
     CartPage cartpage  = PageFactory.initElements(driver, CartPage.class);
     CheckoutPage checkoutpage  = PageFactory.initElements(driver, CheckoutPage.class);
     PaypalPage paypalpage  = PageFactory.initElements(driver, PaypalPage.class);

//Search for a tire
     homepage.searchForATire("2010","Honda","Accord","EX 2 Dr. 4 Cyl.","98003");
     resultspage.clickOnMoreResultsLinkByProductRowNumber(2);
     productpage.clickonAddtoCartButton();
     cartpage.clickOnDeliveryToATireBuyerInstallerRadioButton();
     cartpage.clickOnInstallerRadioButtonByRowNumber(3);
     cartpage.clickOnInstallerListSaveButton();
     try {
         Thread.sleep(3000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     cartpage.clickOnCartCheckoutButton();
    checkoutpage.clickOnCheckoutWithPayPalButton();
     try {
         Thread.sleep(7000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     String currentwindowHandle=driver.getWindowHandle();
     driver.switchTo().frame("injectedUl");
     paypalpage.loginToPayPal("a@aaa.com","xyzssss");
     driver.switchTo().window(currentwindowHandle);
     if(paypalpage.checkForErrorOnPayPalPage()){
         paypalpage.clickCancelAndReturnButton();
     }
 }

 @AfterSuite()
    public void teardown(){
     driver.quit();
 }
}
