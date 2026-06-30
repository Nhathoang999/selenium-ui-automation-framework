package com.automation.tests.catalog;

import com.automation.base.BaseTest;
import com.automation.pages.auth.LoginPage;
import com.automation.pages.catalog.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    @Test(groups = {"regression"})
    public void testProductSortingByPriceHighToLow() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        loginPage.loginAs("standard_user", "secret_sauce");
        
        // Sắp xếp giá từ cao đến thấp
        productPage.selectSortOption("Price (high to low)");
        
        // Sản phẩm đắt nhất là "Sauce Labs Fleece Jacket" giá $49.99
        String firstPrice = productPage.getFirstProductPrice();
        Assert.assertEquals(firstPrice, "$49.99", "Sorting by Price (high to low) failed.");
    }
}
