package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentText;

    //3.3 Verify the text ‘Components’
    public String getComponentText(){
        Reporter.log("Verify the text ‘Components’" + componentText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text ‘Components’");
        return getTextFromElement(componentText);
    }
}
