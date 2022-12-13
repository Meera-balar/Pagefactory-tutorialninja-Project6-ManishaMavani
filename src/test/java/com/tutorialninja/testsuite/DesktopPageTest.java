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
public class DesktopPageTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException{
        homePage.navigateToDesktopPage();
        homePage.clickOnShowAllDesktop();
        desktopPage.clickOnSortByPosition();
        desktopPage.selectProductSortedNameAToZ("Name (Z - A)");
        Assert.assertEquals(desktopPage.getSortedProductList(), desktopPage.expectedList(), "Products not sorted as expected.");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.navigateToDesktopPage();
        homePage.clickOnShowAllDesktop();
        homePage.clickOnCurrency("£ Pound Sterling");
        desktopPage.selectProductSortedNameAToZ("Name (Z - A)");
        desktopPage.clickOnProductHPLP3065();
        Assert.assertEquals(productPage.getProductHPLP3065(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDate("2022", "November", "30");
        productPage.addQuantityForProduct("1");
        productPage.clickOnAddToCartButton();
        Assert.assertEquals(productPage.getSuccessText(), "Success: You have added HP LP3065 to your shopping cart!" + "\n×", "Product not added to cart");
        productPage.clickOnShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getShoppingCartText().contains("Shopping Cart"), "Shopping cart page not opened");
        Assert.assertEquals(shoppingCartPage.getProductText(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(shoppingCartPage.getDeliveryDateOfProduct().contains("2022-11-30"), "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.getProductModel(), "Product 21", "Model not matched");
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "£74.73", "Total not matched");
    }
}
