package uz.agro.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import uz.agro.core.BasePage;

public class SetPinPage extends BasePage {
    @AndroidFindBy(xpath = "//*[@text='5']")
    private WebElement pinBtn;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button")
    private WebElement biometricAccess;

    @Step("Pin page is opened")
    public boolean pinPageIsOpened() {
        return isVisible(pinBtn);
    }

    @Step("Set pin 5555")
    public void setPin() throws InterruptedException {
        pinBtn.click();
        pinBtn.click();
        pinBtn.click();
        pinBtn.click();
        Thread.sleep(100);
        pinBtn.click();
        pinBtn.click();
        pinBtn.click();
        pinBtn.click();

        biometricAccess.click();

    }

}
