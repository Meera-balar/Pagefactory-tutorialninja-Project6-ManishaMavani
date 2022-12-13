package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement checkOutText;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckOut;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postcode;
    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;
    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement region;
    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement continueButton1;
    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement textArea;
    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsCondition;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButton2;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    //2.16 Verify the text “Checkout”
    public String getCheckoutText(){
        Reporter.log("Verify the text “Checkout” " +checkOutText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text “Checkout”");
        return getTextFromElement(checkOutText);
    }

    //2.17 Verify the Text “New Customer”
    public String getNewCustomerText(){
        Reporter.log("Verify the Text “New Customer” " + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Text “New Customer”");
        return getTextFromElement(newCustomerText);
    }

    //2.18 Click on “Guest Checkout” radio button
    public void clickOnGuestCheckOutRadioButton(){
        Reporter.log("Click on “Guest Checkout” radio button " + guestCheckOut.toString());
        clickOnElement(guestCheckOut);
        CustomListeners.test.log(Status.PASS,"Click on “Guest Checkout” radio button");
    }

    //2.19 Click on “Continue” tab
    public void clickOnContinueButton(){
        Reporter.log("Click on “Continue” tab " +continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS,"Click on “Continue” tab");
    }
    //2.20******************************Fill All Mandatory Field***********************************************//

    //Enter firstname
    public void enterFirstName(String name){
        Reporter.log("Enter firstname"+name+ "to firstname field "+firstName.toString());
        sendTextToElement(firstName, name);
        CustomListeners.test.log(Status.PASS,"Enter firstname " + name);
    }

    //Enter lastname
    public void enterLastName(String name){
        Reporter.log("Enter lastname"+name+ "to lastname field "+lastName.toString());
        sendTextToElement(lastName, name);
        CustomListeners.test.log(Status.PASS,"Enter lastname " + name);
    }

    //Enter email
    public void enterEmailId(String email){
        Reporter.log("Enter email"+email+ "to email field "+emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
    }

    //Enter phoneNumber
    public void enterTelephone(String phoneNumber){
        Reporter.log("Enter phoneNumber"+phoneNumber+ "to phoneNumber field "+telephone.toString());
        sendTextToElement(telephone, phoneNumber);
        CustomListeners.test.log(Status.PASS,"Enter phoneNumber " + phoneNumber);
    }

    //Enter address Line 1
    public void enterAddressLine1(String addressLine){
        Reporter.log("Enter address Line 1"+addressLine+ "to address field "+address.toString());
        sendTextToElement(address, addressLine);
        CustomListeners.test.log(Status.PASS,"Enter address Line 1 " + addressLine);
    }

    //Enter city
    public void enterCity(String cityName){
        Reporter.log("Enter city"+cityName+ "to city field "+city.toString());
        sendTextToElement(city, cityName);
        CustomListeners.test.log(Status.PASS,"Enter city " +cityName);
    }

    //Enter postcode
    public void enterPostCode(String postCode){
        Reporter.log("Enter postcode"+postCode+ "to postcode field "+postcode.toString());
        sendTextToElement(postcode, postCode);
        CustomListeners.test.log(Status.PASS,"Enter postcode" + postCode);
    }

    //Select country
    public void selectCountry(String countryName){
        Reporter.log("Select country"+countryName+ "to country field "+country.toString());
        selectByVisibleTextFromDropDown(country,countryName);
        CustomListeners.test.log(Status.PASS,"Select country " + countryName);
    }

    //Select state
    public void selectRegion(String regionName){
        Reporter.log("Select state"+regionName+ "to statel field "+region.toString());
        selectByVisibleTextFromDropDown(region,regionName);
        CustomListeners.test.log(Status.PASS,"Select state" + regionName);

    }

    //2.21 Click on continue button
    public void clickOnContinue(){
        Reporter.log(" Click on continue button " + continueButton1.toString());
        clickOnElement(continueButton1);
        CustomListeners.test.log(Status.PASS," Click on continue button");
    }

    //2.22 Add Comments About your order into text area
    public void addCommentsToTextArea(String text){
        Reporter.log("Enter comments "+text+ "in to text area "+textArea.toString());
        sendTextToElement(textArea,text);
        CustomListeners.test.log(Status.PASS,"Add Comments About your order into text area " + text);
    }

    //2.23 Check the Terms & Conditions check box
    public void checkTermsAndConditionCheckBox(){
        Reporter.log(" Check the Terms & Conditions check box " + termsCondition.toString());
        clickOnElement(termsCondition);
        CustomListeners.test.log(Status.PASS," Check the Terms & Conditions check box");
    }

    //2.24 Click on “Continue” button
    public void clickContinue(){
        Reporter.log("Click on “Continue” button " + continueButton2.toString());
        clickOnElement(continueButton2);
        CustomListeners.test.log(Status.PASS,"Click on “Continue” button");
    }

    //2.25 Verify the message “Warning: Payment method required!”
    public String getWarningMessage(){
        Reporter.log("Verify the message “Warning: Payment method required!” " +warningMessage.toString());
        CustomListeners.test.log(Status.PASS,"Verify the message “Warning: Payment method required!”");
        return getTextFromElement(warningMessage);
    }
}
