package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LogoutPage extends Utility {
    //3.16 Verify the text “Account Logout”
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Account Logout']")
    WebElement getLogoutText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickContinueButton;
    public String getAccountLogoutText(){
        //Verify text "Account Logout"
        Reporter.log("Verify text \"Account Logout\" " + getLogoutText.toString());
        CustomListeners.test.log(Status.PASS,"Verify text \"Account Logout\"");
        return getTextFromElement(getLogoutText);
    }
    //3.17 Click on Continue button
    public void clickOnContinueButton(){
        Reporter.log("Clicking on Continue Button " + clickContinueButton.toString());
        clickOnElement(clickContinueButton);
        CustomListeners.test.log(Status.PASS,"Click on Continue Button");
    }
}
