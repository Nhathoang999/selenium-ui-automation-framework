package com.automation.pages.checkout;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By cartItems = By.className("cart_item");
    private final By checkoutButton = By.id("checkout");

    public int getNumberOfItemsInCart() {
        // Wait for at least one element or return 0
        try {
            waitForElementVisible(cartItems);
            return driver.findElements(cartItems).size();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public boolean isCartNotEmpty() {
        return getNumberOfItemsInCart() > 0;
    }
    
    public void clickCheckout() {
        click(checkoutButton);
    }
}
