package com.automation.tests.catalog;

import com.automation.base.BaseTest;
import com.automation.pages.auth.LoginPage;
import com.automation.pages.catalog.ProductPage;
import com.automation.pages.checkout.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        // 1. Thực hiện Đăng nhập
        loginPage.loginAs("standard_user", "secret_sauce");
        Assert.assertTrue(productPage.isProductPageDisplayed(), "User should be on Product page after login");

        // 2. Click thêm sản phẩm "Backpack" vào giỏ hàng
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartItemCount(), "1", "Cart badge should show exactly 1 item");

        // 3. Mở giỏ hàng và kiểm tra xem có sản phẩm không
        productPage.goToCart();
        Assert.assertTrue(cartPage.isCartNotEmpty(), "Cart should not be empty after adding a product");
    }
}
