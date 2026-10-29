package uz.agro.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import uz.agro.core.BasePage;

public class EnterPasswordPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement passwordArea;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private WebElement nextBtn;

    @Step("Entering password")
    public void enterPassword() {
        passwordArea.click();
        passwordArea.sendKeys("Parol12@");
        nextBtn.click();


    }
}
