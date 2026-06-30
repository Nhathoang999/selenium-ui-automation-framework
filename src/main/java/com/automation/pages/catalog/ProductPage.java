package com.automation.pages.catalog;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final By pageTitle = By.cssSelector(".title");
    private final By addToCartBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    public boolean isProductPageDisplayed() {
        return isElementDisplayed(pageTitle) && getText(pageTitle).equalsIgnoreCase("Products");
    }

    public void addBackpackToCart() {
        click(addToCartBackpackBtn);
    }

    public String getCartItemCount() {
        return getText(cartBadge);
    }

    public void goToCart() {
        click(cartIcon);
    }

    private final By sortDropdown = By.className("product_sort_container");
    private final By firstProductPrice = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price");

    public void selectSortOption(String optionText) {
        org.openqa.selenium.WebElement dropdown = waitForElementVisible(sortDropdown);
        new org.openqa.selenium.support.ui.Select(dropdown).selectByVisibleText(optionText);
    }
    
    public String getFirstProductPrice() {
        return getText(firstProductPrice);
    }
}
