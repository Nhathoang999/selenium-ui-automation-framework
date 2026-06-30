package com.automation.pages.checkout;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {
    private final By successMessage = By.className("complete-header");

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}
