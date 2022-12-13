package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement clickOnLogin;
    @CacheLookup
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    //2.3 Verify the text “Returning Customer”.
    public String getReturningCustomerTextFromLoginPage(){
        Reporter.log("Verify the text “Returning Customer” " + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text “Returning Customer”");
        return getTextFromElement(returningCustomerText);
    }

    //4.3 Enter Email address
    public void enterEmail(String email){
        Reporter.log("Enter email"+email+ "to email field "+emailField.toString());
        sendTextToElement(emailField,email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
    }

    //4.5 Enter Password
    public void enterPassword(String password){
        Reporter.log("Enter password"+password+ "to password field "+passwordField.toString());
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    //4.6 Click on Login button
    public  void clickOnLoginButton(){
        Reporter.log("Clicking on Login Button " + clickOnLogin.toString());
        clickOnElement(clickOnLogin);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    //4.7 Verify text “My Account”
    public String getMyAccountText(){
        Reporter.log("Verify text “My Account”" + myAccountText.toString());
        CustomListeners.test.log(Status.PASS,"Verify text “My Account”");
        return getTextFromElement(myAccountText);
    }

}
