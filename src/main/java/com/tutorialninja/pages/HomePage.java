package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuTabs;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotebookTab;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;
    @CacheLookup
    @FindBy(linkText = "Show All Desktops")
    WebElement showAllDesktopTab;
    @CacheLookup
    @FindBy(linkText = "Show All Laptops & Notebooks")
    WebElement showAllLaptopAndNotebookTab;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList1;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
    List<WebElement> myAccountOptions;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
    List<WebElement> myAccountOptions1;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink1;


    //This method will check whatever parameter is passed it click on it
    public void selectMenu(String menu){
        Reporter.log("Click "+menu+ "from hompage top menubar  "+topMenuTabs.toString());

        List<WebElement> topMenuList = topMenuTabs;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuTabs;
        }
        CustomListeners.test.log(Status.PASS,"Click on  " + menu);
    }

    // 1.1 Mouse hover on “Desktops” Tab and click
    public void navigateToDesktopPage(){
        Reporter.log("Mouse hover on “Desktops” Tab and click " + desktopTab.toString());
        mouseHoverToElementAndClick(desktopTab);
        CustomListeners.test.log(Status.PASS,"Mouse hover on “Desktops” Tab and click");
    }

    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    public void navigateToLaptopAndNotebooksPage(){
        Reporter.log("Mouse hover on “Laptops & Notebooks” Tab and click " + laptopAndNotebookTab.toString());
        mouseHoverToElementAndClick(laptopAndNotebookTab);
        CustomListeners.test.log(Status.PASS,"Mouse hover on “Laptops & Notebooks” Tab and click");
    }

    // 3.1 Mouse hover on “Components” Tab and click
    public void navigateToComponentsPage(){
        Reporter.log(" Mouse hover on “Components” Tab and click " + componentsTab.toString());
        mouseHoverToElementAndClick(componentsTab);
        CustomListeners.test.log(Status.PASS," Mouse hover on “Components” Tab and click");
    }

    //Click on Show All Desktop tab
    public void clickOnShowAllDesktop(){
        Reporter.log("Click on Show All Desktop tab " +showAllDesktopTab.toString());
        clickOnElement(showAllDesktopTab);
        CustomListeners.test.log(Status.PASS,"Click on Show All Desktop tab");
    }

    //Click on Show All LaptopAndNotebook Tab
    public void clickOnShowAllLaptopAndNoteBook(){
        Reporter.log("Click on Show All LaptopAndNotebook Tab " + showAllLaptopAndNotebookTab.toString());
        clickOnElement(showAllLaptopAndNotebookTab);
        CustomListeners.test.log(Status.PASS,"Click on Show All LaptopAndNotebook Tab");
    }

    //This method will select currency from drop down
    public void clickOnCurrency(String text) {
        Reporter.log("Clicking on Currency on top of page " + currencyLink.toString());
        clickOnElement(currencyLink);
        CustomListeners.test.log(Status.PASS,"Clicking on Currency on top of page");
        Reporter.log("Select "+text+ " from currency drop down list "+currencyList1.toString());
        List<WebElement> currencyList = currencyList1;
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase(text)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"select currency from drop down " + text);
    }

    //This method will select options from myAccount options drop down
    public void selectMyAccountOptions(String option) {
        Reporter.log("Select "+option+ "from myAccount drop down list "+myAccountOptions.toString());
        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
        }
        CustomListeners.test.log(Status.PASS,"From myAccount option Select " + option);
    }

    public void selectMyAccountOptions1(String option) {
        Reporter.log("Select "+option+ "from myAccount drop down list "+myAccountOptions1.toString());
        List<WebElement> myAccountList = myAccountOptions1;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions1;
        }
        CustomListeners.test.log(Status.PASS,"From myAccount option Select " + option);
    }

    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully
    //1.1 Click on My Account Link.
    public void clickOnMyAccountLink(){
        Reporter.log("Clicking on My Account Link " +myAccountLink.toString());
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS,"Click on My Account Link");
    }
    public void clickOnMyAccountLink1(){
        Reporter.log("Clicking on My Account Link " +myAccountLink1.toString());
        clickOnElement(myAccountLink1);
        CustomListeners.test.log(Status.PASS,"Click on My Account Link");
    }
}

