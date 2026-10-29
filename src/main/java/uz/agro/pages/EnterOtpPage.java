package uz.agro.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uz.agro.core.BasePage;

import java.time.Duration;

public class EnterOtpPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement otpArea;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private WebElement nextBtn;

    @Step("Otp area is loaded")
    public boolean isOpened(){
        return isVisible(otpArea);
    }

    @Step("Entering otp code")
    public void enterOtCode(String otpCode){
        otpArea.click();
        otpArea.sendKeys(otpCode);
        nextBtn.click();
    }
}
