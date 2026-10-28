package uz.agro.tests.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import uz.agro.driver.DriverManager;

public class FailureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (DriverManager.get() != null) {
            screenshot();
            pageSource();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] screenshot() {
        return DriverManager.get().getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/xml")
    private String pageSource() {
        return DriverManager.get().getPageSource();
    }
}
