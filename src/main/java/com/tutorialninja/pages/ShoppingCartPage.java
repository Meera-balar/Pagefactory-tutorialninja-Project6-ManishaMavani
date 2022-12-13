package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productText;
    @CacheLookup
    @FindBy(xpath = "//small[contains(text(),'Delivery Date: 2022-11-30')]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement productDesktopModel;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement updateButton;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement updateSuccessText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    //2.11 Verify the text "Shopping Cart"
    public String getShoppingCartText(){
        Reporter.log(" Verify the text \"Shopping Cart\" " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS," Verify the text \"Shopping Cart\"");
        return getTextFromElement(shoppingCartText);
    }
    //2.12 Verify the Product name "HP LP3065"
    public String getProductText(){
        Reporter.log("Verify the Product name \"HP LP3065\" " + productText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Product name \"HP LP3065\"");
        return getTextFromElement(productText);
    }
    //2.13 Verify the Delivery Date "2022-11-30"
    public String getDeliveryDateOfProduct(){
        Reporter.log("Verify the Delivery Date \"2022-11-30\" " + deliveryDate.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Delivery Date \"2022-11-30\"");
        return getTextFromElement(deliveryDate);
    }
    //2.14 Verify the Model "Product21"
    public String getProductModel(){
        Reporter.log("Verify the Model \"Product21\" " + productDesktopModel.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Model \"Product21\"");
        return getTextFromElement(productDesktopModel);
    }
    //2.15 Verify the Todat "£74.73"
    public String getTotalPrice(){
        Reporter.log("Verify the Todat \"£74.73\"" +totalPrice.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Todat \"£74.73\"");
        return getTextFromElement(totalPrice);
    }

    //*************************************Laptop*******************************//
    //2.11 Change Quantity "2"
    public void changeQuantityForProduct(String text){
        Reporter.log("Change Quantity"+text+ "to quantity field "+quantityField.toString());
        sendTextToElement(quantityField,text);
        CustomListeners.test.log(Status.PASS,"Enter Quantity " + text);

    }
    //2.12 Click on “Update” Tab
    public void clickOnUpdateQuantity(){
        Reporter.log(" Click on “Update” Tab " + updateButton.toString());
        clickOnElement(updateButton);
        CustomListeners.test.log(Status.PASS," Click on “Update” Tab");
    }
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    public String getUpdateSuccessfullyText(){
        Reporter.log("Getting welcome back text " + updateSuccessText.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From Welcome Back");
        return getTextFromElement(updateSuccessText);
    }
   // 2.15 Click on “Checkout” button
    public void clickOnCheckoutButton(){
        Reporter.log("Click on “Checkout” button " + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS,"Click on “Checkout” button");
    }
}
