package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.*;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
@Listeners(CustomListeners.class)
public class LaptopAndNotebookPageTest extends BaseTest {
    LaptopAndNotebookPage laptopAndNotebookPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        laptopAndNotebookPage = new LaptopAndNotebookPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder(){
        homePage.navigateToLaptopAndNotebooksPage();
        homePage.clickOnShowAllLaptopAndNoteBook();
        laptopAndNotebookPage.clickOnSortByPosition();
        laptopAndNotebookPage.selectProductSortedPriceHighToLow("Price (High > Low)");
        //Assert.assertEquals(Collections.singleton(actual),Collections.singleton(expected),"Product not sorted by price High to Low");
        Assert.assertEquals(laptopAndNotebookPage.getPriceHighToLow(),laptopAndNotebookPage.priceHighToLow(),"Product not sorted by price High to Low");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws  InterruptedException {
        homePage.navigateToLaptopAndNotebooksPage();
        homePage.clickOnShowAllLaptopAndNoteBook();
        homePage.clickOnCurrency("£ Pound Sterling");
        laptopAndNotebookPage.selectProductSortedPriceHighToLow("Price (High > Low)");
        laptopAndNotebookPage.clickOnProductMacBook();
        Assert.assertEquals(productPage.getProductMacBookText(),"MacBook","MacBook Product not display");
        productPage.clickOnAddToCartButton();
        Assert.assertEquals(productPage.getSuccessText(),"Success: You have added MacBook to your shopping cart!" + "\n×","Product not added to cart");
        productPage.clickOnShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getShoppingCartText().contains("Shopping Cart"),"Shopping cart page not opened");
        Assert.assertEquals(shoppingCartPage.getProductText(),"MacBook","Product name not matched");
        shoppingCartPage.changeQuantityForProduct("2");
        shoppingCartPage.clickOnUpdateQuantity();
        Assert.assertTrue(shoppingCartPage.getUpdateSuccessfullyText().contains("Success: You have modified your shopping cart!"),"Cart not modified");
        Assert.assertEquals(shoppingCartPage.getTotalPrice(),"£737.45","Total not matched");
        shoppingCartPage.clickOnCheckoutButton();
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getCheckoutText(),"Checkout","Not Navigate to checkout page");
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getNewCustomerText(),"New Customer","New Customer Text not found");
        checkoutPage.clickOnGuestCheckOutRadioButton();
        checkoutPage.clickOnContinueButton();
        checkoutPage.enterFirstName("Mahi"+getRandomString(3));
        checkoutPage.enterLastName("Patel"+getRandomString(2));
        checkoutPage.enterEmailId("mahi"+getRandomString(3)+"@gmail.com");
        checkoutPage.enterTelephone("07878963869");
        checkoutPage.enterAddressLine1("20,Birmingham road");
        checkoutPage.enterCity("Birmingham");
        checkoutPage.enterPostCode("CV0 10Ol");
        checkoutPage.selectCountry("India");
        checkoutPage.selectRegion("Gujarat");
        checkoutPage.clickOnContinue();
        checkoutPage.addCommentsToTextArea("Happy Christmas!");
        checkoutPage.checkTermsAndConditionCheckBox();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getWarningMessage(),"Warning: Payment method required!" + "\n×","Warning message not displayed");
    }
}
