package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.*;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    LogoutPage logoutPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
        logoutPage = new LogoutPage();
    }


    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.getRegisterText(),"Register Account","Register page not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Manisha"+getRandomString(3));
        registerPage.enterLastName("Mavani"+getRandomString(3));
        registerPage.enterEmail("prime" + getRandomString(4) + "@gmail.com");
        registerPage.enterTelephone("07645879809");
        registerPage.enterPassword("test123");
        registerPage.enterConfirmPassword("test123");
        registerPage.clickOnSubscribeRadioButton("Yes");
        registerPage.clickOnPrivacyPolicyCheckBox();
        registerPage.clickOnContinueButton();
        Assert.assertEquals(registerPage.getAccountCreatedMessage(),"Your Account Has Been Created!","Account not created successfully");
        registerPage.clickOnContinue();
        homePage.clickOnMyAccountLink1();
        homePage.selectMyAccountOptions1("Logout");
        Assert.assertEquals(logoutPage.getAccountLogoutText(),"Account Logout","Not logged out");
        logoutPage.clickOnContinueButton();


    }
}
