package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement productTextHPLP3065;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calenderButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker-days']//table//th[@class='picker-switch']")
    WebElement monthYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]//table//th[normalize-space()='›']")
    WebElement nextButtonOfCalender;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']//table//td")
    List<WebElement> dayText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement getSuccessText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;
    //******************************Desktop**********************//

    //2.5 Verify the Text "HP LP3065"
    public String getProductHPLP3065(){
        Reporter.log("Verify the Text \"HP LP3065\" " +productTextHPLP3065.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Text \"HP LP3065\"");
        return getTextFromElement(productTextHPLP3065);
    }
    //2.6 Select Delivery Date "2022-11-30"
    public void selectDate(String year,String month, String date) {
        Reporter.log("Select "+year+month+date+"to date field "+calenderButton.toString());
        clickOnElement(calenderButton);
        while (true) {
            String monthAndYear = monthYearText.getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonOfCalender);
            }
        }
        List<WebElement> allDates = dayText;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"Select Delivery Date "+year+month+date);
    }

    //2.7.Enter Qty "1” using Select class.
    public void addQuantityForProduct(String text){
        Reporter.log("Enter Qty"+text+ "to quantity field "+quantityField.toString());
        sendTextToElement(quantityField,text);
        CustomListeners.test.log(Status.PASS,"Enter Qty " + text);

    }
    //2.8 Click on “Add to Cart” button
    public void clickOnAddToCartButton(){
        Reporter.log("Clicking on Login Button " + addToCartButton.toString());
        try{
            Thread.sleep(500);
            clickOnElement(addToCartButton);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    public String getSuccessText(){
        Reporter.log("Verify the Message “Success: You have added HP LP3065 to your shopping cart!” " +getSuccessText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Message “Success: You have added HP LP3065 to your shopping cart!”");
        return getTextFromElement(getSuccessText);
    }

    //2.10 Click on link “shopping cart” display into success message
    public void clickOnShoppingCartButton(){
        Reporter.log("Click on link “shopping cart” display into success message " + shoppingCartButton.toString());

        try{
            Thread.sleep(500);
            clickOnElement(shoppingCartButton);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        CustomListeners.test.log(Status.PASS,"Click on link “shopping cart” display into success message");

    }

    //****************************************Laptop***********************//
   //Verify text MacBook
    public String getProductMacBookText(){
        Reporter.log("Verify text MacBook " + macBookText.toString());
        CustomListeners.test.log(Status.PASS,"Verify text MacBook");
        return getTextFromElement(macBookText);
    }
}
