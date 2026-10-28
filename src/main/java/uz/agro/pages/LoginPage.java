package uz.agro.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import uz.agro.core.BasePage;


public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    private WebElement languageBtn;


    @Step("Check opening login page")
    public boolean isLoaded() {
        return isVisible(languageBtn);
    }
    @Step("Click lang btn")
    public void clickLangBtn() {
        languageBtn.click();
    }
}
