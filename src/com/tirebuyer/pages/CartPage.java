package com.tirebuyer.pages;

import com.tirebuyer.automation.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by divi on 8/9/2016.
 */
public class CartPage {

    final WebDriver driver;

    @FindBy(xpath = ("//*[@id='0']//div[@class='installer-radio pull-left ph at_cart_installer_radioButton']"))
    @CacheLookup
    public WebElement delivery_to_a_tire_buyer_radio_btn;

    @FindBy(xpath = ("//*[@id='installersList']//div[@class='item-number pull-left text-right']/span"))
    @CacheLookup
    public List<WebElement> installer_list_radio_btn;

    @FindBy(xpath = ("//*[@id='fbBox']//div[@class='installerSaveButton text-right']/a"))
    @CacheLookup
    public WebElement installer_list_save_btn;

    @FindBy(id = "gotoCheckoutBtn")
    @CacheLookup
    public WebElement cart_checkout_btn;



    public CartPage(WebDriver driver)

    {
        this.driver = driver;
    }

    public void clickOnDeliveryToATireBuyerInstallerRadioButton()
    {
        GenericMethods.click(delivery_to_a_tire_buyer_radio_btn);
        GenericMethods.waitForElementToAppear(driver,installer_list_save_btn);

    }

    public void clickOnInstallerRadioButtonByRowNumber(int rownumber)
    {
        GenericMethods.click(installer_list_radio_btn.get(rownumber-1));

    }

    public void clickOnInstallerListSaveButton()
    {
        GenericMethods.click(installer_list_save_btn);

    }

    public void clickOnCartCheckoutButton()
    {
        GenericMethods.click(cart_checkout_btn);
    }
}
