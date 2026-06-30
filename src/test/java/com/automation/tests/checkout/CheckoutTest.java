package com.automation.tests.checkout;

import com.automation.base.BaseTest;
import com.automation.pages.auth.LoginPage;
import com.automation.pages.catalog.ProductPage;
import com.automation.pages.checkout.CartPage;
import com.automation.pages.checkout.CheckoutCompletePage;
import com.automation.pages.checkout.CheckoutStepOnePage;
import com.automation.pages.checkout.CheckoutStepTwoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"regression"})
    public void testEndToEndCheckoutFlow() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckoutStepOnePage stepOnePage = new CheckoutStepOnePage();
        CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage();
        CheckoutCompletePage completePage = new CheckoutCompletePage();

        // 1. Đăng nhập
        loginPage.loginAs("standard_user", "secret_sauce");

        // 2. Thêm sản phẩm & Vào giỏ hàng
        productPage.addBackpackToCart();
        productPage.goToCart();

        // 3. Tiến hành thanh toán
        cartPage.clickCheckout();

        // 4. Bước 1: Điền thông tin cá nhân
        stepOnePage.enterPersonalDetails("John", "Doe", "12345");
        stepOnePage.clickContinue();

        // 5. Bước 2: Xác nhận hóa đơn
        stepTwoPage.clickFinish();

        // 6. Kiểm tra thông báo mua hàng thành công
        String actualMessage = completePage.getSuccessMessage();
        Assert.assertEquals(actualMessage, "Thank you for your order!", "Checkout flow did not complete successfully");
    }

    @Test(groups = {"negative", "regression"})
    public void testCheckoutWithMissingInfo() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckoutStepOnePage stepOnePage = new CheckoutStepOnePage();

        loginPage.loginAs("standard_user", "secret_sauce");
        productPage.addBackpackToCart();
        productPage.goToCart();
        cartPage.clickCheckout();

        // Điền thiếu Last Name
        stepOnePage.enterPersonalDetails("John", "", "12345");
        stepOnePage.clickContinue();

        String error = stepOnePage.getErrorMessage();
        Assert.assertEquals(error, "Error: Last Name is required", "Missing info error message is incorrect");
    }
}
