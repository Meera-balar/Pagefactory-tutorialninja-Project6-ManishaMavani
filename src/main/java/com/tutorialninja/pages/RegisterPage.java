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

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeButton;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement accountCreatedMessage;
    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton1;

    //1.3 Verify the text “Register Account”.
    public String getRegisterText(){
        Reporter.log("Verify the text “Register Account”. " + registerText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text “Register Account”.");
        return getTextFromElement(registerText);
    }

    //3.3 Enter Firstname
    public void enterFirstName(String firstName){
        Reporter.log("Enter Firstname"+firstName+ "to Firstname field "+firstNameField.toString());
        sendTextToElement(firstNameField,firstName);
        CustomListeners.test.log(Status.PASS,"Enter Firstname " + firstName);
    }

    //3.4 Enter Lastname
    public void enterLastName(String lastName){
        Reporter.log("Enter Lastname"+lastName+ "to Lastname field "+lastNameField.toString());
        sendTextToElement(lastNameField,lastName);
        CustomListeners.test.log(Status.PASS,"Enter Lastname " + lastName);
    }
    //3.5 Enter Email
    public void enterEmail(String email){
        Reporter.log("Enter email"+email+ "to email field "+emailField.toString());
        sendTextToElement(emailField,email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " +email);
    }

    //3.6 Enter Telephone
    public void enterTelephone(String telephone){
        Reporter.log("Enter Telephone"+telephone+ "to Telephone field "+telephoneField.toString());

        CustomListeners.test.log(Status.PASS,"Enter Telephone " +telephone);
        sendTextToElement(telephoneField,telephone);
    }

    //3.7 Enter Password
    public void enterPassword(String password){
        Reporter.log("Enter Password "+password+ "to Password field "+passwordField.toString());

        CustomListeners.test.log(Status.PASS," Enter Password " + password);
        sendTextToElement(passwordField,password);
    }
    //3.8 Enter ConfirmPassword
    public void enterConfirmPassword(String confirmPassword){
        Reporter.log("Enter ConfirmPassword"+confirmPassword+ "to ConfirmPassword field "+confirmPasswordField.toString());
        sendTextToElement(confirmPasswordField,confirmPassword);
        CustomListeners.test.log(Status.PASS,"Enter ConfirmPassword " + confirmPassword);

    }

    //3.9 Select Subscribe Yes radio button
    public void clickOnSubscribeRadioButton(String text){
        Reporter.log("Select Subscribe"+text+ "radio button "+subscribeButton.toString());
        List<WebElement> radioButtons = subscribeButton;
        for (WebElement e : radioButtons) {
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"Select Subscribe " + text);
    }

    //3.10 Click on Privacy Policy check box
    public void clickOnPrivacyPolicyCheckBox(){
        Reporter.log("Click on Privacy Policy check box " + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS,"Click on Privacy Policy check box");
    }
    //3.11 Click on Continue button
    public void clickOnContinueButton(){
        Reporter.log("Clicking on Continue Button " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS,"Click on Continue Button");
    }
    //3.12 Verify the message “Your Account Has Been Created!”
    public String getAccountCreatedMessage(){
        Reporter.log("Verify the message “Your Account Has Been Created!”" + accountCreatedMessage.toString());
        CustomListeners.test.log(Status.PASS,"Verify the message “Your Account Has Been Created!”");
        return getTextFromElement(accountCreatedMessage);
    }
    //3.13 Click on Continue button
    public void clickOnContinue(){
        Reporter.log("Clicking on Continue Button " + continueButton1.toString());
        clickOnElement(continueButton1);
        CustomListeners.test.log(Status.PASS,"Click on Continue Button");
    }
}
