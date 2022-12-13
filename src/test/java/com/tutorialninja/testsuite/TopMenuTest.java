package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.*;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    LaptopAndNotebookPage laptopAndNotebookPage;
    ComponentsPage componentsPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopAndNotebookPage = new LaptopAndNotebookPage();
        componentsPage = new ComponentsPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.navigateToDesktopPage();
        homePage.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        Assert.assertEquals(desktopPage.getDesktopText(),expectedText,"Not navigate to Desktop page");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.navigateToLaptopAndNotebooksPage();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(laptopAndNotebookPage.getLaptopAndNotebookText(),expectedText,"Not navigate to Laptops and Notebooks page");
    }
    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.navigateToComponentsPage();
        homePage.selectMenu("Show All Components");
        String expectedText = "Components";
        Assert.assertEquals(componentsPage.getComponentText(),expectedText,"Not navigate to Laptops and Notebooks page");
    }

}
