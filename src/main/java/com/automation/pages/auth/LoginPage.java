package com.automation.pages.auth;

import com.automation.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // 1. Locators (Private to enforce encapsulation)
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // 2. Page Actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    // 3. Business Flows
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    public boolean isLoginButtonVisible() {
        return isElementDisplayed(loginButton);
    }
}
