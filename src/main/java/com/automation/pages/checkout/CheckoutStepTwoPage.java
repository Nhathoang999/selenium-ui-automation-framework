package com.automation.pages.checkout;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class CheckoutStepTwoPage extends BasePage {
    private final By finishButton = By.id("finish");

    public void clickFinish() {
        click(finishButton);
    }
}
