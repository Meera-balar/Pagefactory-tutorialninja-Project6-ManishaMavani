package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNotebookText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement clickOnSortBy;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productPriceList;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productPriceList1;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement productMacBook;

    //2.3 Verify the text ‘Laptops & Notebooks’
    public String getLaptopAndNotebookText() {
        Reporter.log("Verify the text ‘Laptops & Notebooks’ " + laptopAndNotebookText.toString());
        CustomListeners.test.log(Status.PASS, "Verify the text ‘Laptops & Notebooks’");
        return getTextFromElement(laptopAndNotebookText);
    }


    public void clickOnSortByPosition() {
        Reporter.log("Clicking on Login Button " + clickOnSortBy.toString());
        clickOnElement(clickOnSortBy);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    //1.3 Select Price(High>Low) option from drop down
    public void selectProductSortedPriceHighToLow(String text) {
        Reporter.log("Select " + text + " option from drop down" + clickOnSortBy.toString());
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        CustomListeners.test.log(Status.PASS, "Select option from drop down" + text);
    }

    // verify Product sorted  price High to low
    public List<Double> priceHighToLow() {
        Reporter.log("Verify Product sorted  price High to low " + productPriceList1.toString());
        CustomListeners.test.log(Status.PASS, "Verify Product sorted  price High to low");

        // Get all the products price and stored into array list
        List<WebElement> products = productPriceList1;
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        // Sort By Reverse order
        // Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }

    public List<Double> getPriceHighToLow() {
        // Get all the products price and stored into array list
        Collections.sort(priceHighToLow(), Collections.reverseOrder());
        List<WebElement> products = productPriceList;
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortByPrice;
    }


    //2.4 Select product MacBook
    public void clickOnProductMacBook() {
        Reporter.log("Select product MacBook " + productMacBook.toString());
        clickOnElement(productMacBook);
        CustomListeners.test.log(Status.PASS, "Select product MacBook");
    }
}
