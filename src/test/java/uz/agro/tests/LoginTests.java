package uz.agro.tests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import uz.agro.pages.LoginPage;
import uz.agro.utils.RetryAnalyzer;

@Feature("Login")
public class LoginTests extends BaseTest {

    @Test(description = "Opening login page", retryAnalyzer = RetryAnalyzer.class)
    public void loginPageOpens() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.isLoaded(), "Login page is not opening.");
        login.clickLangBtn();

    }

}
