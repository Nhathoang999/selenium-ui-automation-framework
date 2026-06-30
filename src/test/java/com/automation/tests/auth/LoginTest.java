package com.automation.tests.auth;

import com.automation.base.BaseTest;
import com.automation.data.LoginDataProvider;
import com.automation.pages.auth.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage();
        
        loginPage.loginAs("standard_user", "secret_sauce");
        
        // Assertion validates we successfully left the login page
        Assert.assertFalse(loginPage.isLoginButtonVisible(), 
            "Login button should not be visible after successful login.");
    }

    // Note: dataProvider and dataProviderClass are mapped here
    @Test(
        dataProvider = "invalidLoginData", 
        dataProviderClass = LoginDataProvider.class, 
        groups = {"negative", "regression"}
    )
    public void testLoginWithInvalidCredentials(String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage();
        
        loginPage.loginAs(username, password);
        
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains(expectedError), 
            "Expected error: '" + expectedError + "', but got: '" + actualError + "'");
    }
}
