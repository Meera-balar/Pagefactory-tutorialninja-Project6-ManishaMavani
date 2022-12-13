package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LoginPage;
import com.tutorialninja.pages.LogoutPage;
import com.tutorialninja.pages.RegisterPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    LogoutPage logoutPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        logoutPage = new LogoutPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.getReturningCustomerTextFromLoginPage(), "Returning Customer", "Login page not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmail("prime123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getMyAccountText(),"My Account","Login not success");
        homePage.clickOnMyAccountLink1();
        homePage.selectMyAccountOptions1("Logout");
        Assert.assertEquals(logoutPage.getAccountLogoutText(),"Account Logout","Not Log out");
        logoutPage.clickOnContinueButton();
    }
}
