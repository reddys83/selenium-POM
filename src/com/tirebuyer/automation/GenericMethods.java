package com.tirebuyer.automation;
import com.tirebuyer.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by divi on 8/9/2016.
 */
public class GenericMethods {

    public static void selectAnItemFromDropdown(WebElement element,String value)
    {
        new Select(element).selectByVisibleText(value);
    }


    public static void enterTextBoxValue(WebElement element,String value){
        element.sendKeys(value);
    }
    public static void click(WebElement element){
        if(element.isEnabled())
        element.click();
        else{
            Assert.assertFalse(true,"Element is disabled");
        }
    }

    public static void waitForElementToAppear(WebDriver driver,WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public static boolean verifyWebElementDisplayOnAPage(WebElement element){
        return element.isDisplayed();
    }
}
