package uz.agro.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import uz.agro.core.BasePage;

public class PhoneEnterPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"+998 90 123 45 67\"]")
    private WebElement phoneArea;
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private WebElement nextBtn;
    @Step("Click Next")
    public void clickContinueBtn() {
        nextBtn.click();
    }


    @Step("Check opening phone page")
    public boolean isLoaded() {
        return isVisible(phoneArea);
    }
    @Step("Click phone area and enter phone number")
    public void clickPhoneAreaAndEnterPhoneNumber(String phoneNumber) {
        phoneArea.click();
        phoneArea.sendKeys(phoneNumber);
    }
}
