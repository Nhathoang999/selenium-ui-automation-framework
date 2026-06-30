package com.automation.pages.checkout;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class CheckoutStepOnePage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public void enterPersonalDetails(String firstName, String lastName, String postalCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
    }

    private final By errorMessage = By.cssSelector("[data-test='error']");

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
