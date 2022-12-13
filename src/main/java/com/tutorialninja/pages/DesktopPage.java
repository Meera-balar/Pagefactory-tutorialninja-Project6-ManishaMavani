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

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement clickOnSortBy;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList1;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement productTextHPLP3065;

    //1.3 Verify the text ‘Desktops’
    public String getDesktopText() {
        Reporter.log("Verify the text ‘Desktops’" +desktopText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text ‘Desktops’");
        return getTextFromElement(desktopText);
    }

   // Click on sort by position
    public void clickOnSortByPosition() {
        Reporter.log("Click on sort by position " + clickOnSortBy.toString());
        clickOnElement(clickOnSortBy);
        CustomListeners.test.log(Status.PASS,"Click on sort by position");
    }
    //1.4 Verify product sorted Z-A
    public ArrayList expectedList() {

        // Get all the products name and stored into array list
        List<WebElement> products = productsList1;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
       // Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public ArrayList getSortedProductList() {
        // Get all the products name and stored into array list
        Collections.reverse(expectedList());
        List<WebElement> products = productsList;


        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        return afterSortByZToAProductsName;
    }

    //1.3 Select option product sorted by name Z -A
    public void selectProductSortedNameAToZ(String text) {
        Reporter.log("Select option product sorted by " +text+ "from sort by options "+clickOnSortBy.toString());
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        CustomListeners.test.log(Status.PASS,"Select option product sorted by " + text);
    }

    //2.4 click the Product HPLP3065
    public void clickOnProductHPLP3065() {
        Reporter.log("Clicking on Login Button " + productTextHPLP3065.toString());
        clickOnElement(productTextHPLP3065);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }
}

