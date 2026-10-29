package uz.agro.tests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import uz.agro.pages.*;
import uz.agro.utils.RetryAnalyzer;

@Feature("Login")
public class LoginTests extends BaseTest {

    @Test(description = "Opening login page", retryAnalyzer = RetryAnalyzer.class, priority = 0)
    public void loginPageOpens() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.isLoaded(), "Login page is not opening.");
        login.clickLangBtn();

    }

    @Test(description = "Phone entering page",  retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void phoneEnteringPage() {
        PhoneEnterPage phoneEnter = new PhoneEnterPage();
        Assert.assertTrue(phoneEnter.isLoaded(), "Phone entering page is not opening.");
        phoneEnter.clickPhoneAreaAndEnterPhoneNumber("930795522");
        phoneEnter.clickContinueBtn();
    }

    @Test(description = "Entering password page",   retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void passwordEnteringPage() {
        EnterPasswordPage enterPassword = new EnterPasswordPage();
        enterPassword.enterPassword();
    }

    @Test(description = "Entering OTP code",   retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void otpEnteringCode() throws InterruptedException {
        EnterOtpPage enterOtp = new EnterOtpPage();
        Assert.assertTrue(enterOtp.isOpened(), "Otp entering page is not opening.");
        enterOtp.enterOtCode("000002");
        Thread.sleep(200);
    }

    @Test(description = "Pin set page", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void pinSetPage() throws InterruptedException {
        SetPinPage setPinPage = new SetPinPage();
        setPinPage.setPin();
    }
}
