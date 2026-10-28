package uz.agro.tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import uz.agro.driver.DriverFactory;
import uz.agro.driver.DriverManager;
import uz.agro.tests.listeners.FailureListener;

@Listeners(FailureListener.class)
public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        AndroidDriver driver = DriverFactory.create();
        DriverManager.set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quit();
    }
}
