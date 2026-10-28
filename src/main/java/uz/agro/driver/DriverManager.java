package uz.agro.driver;

import io.appium.java_client.android.AndroidDriver;

public final class DriverManager {
    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {}

    public static AndroidDriver get() {
        return DRIVER.get();
    }

    public static void set(AndroidDriver driver) {
        DRIVER.set(driver);
    }

    public static void quit() {
        AndroidDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
