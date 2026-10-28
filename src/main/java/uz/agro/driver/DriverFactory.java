
package uz.agro.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import uz.agro.config.Config;

import java.net.URI;
import java.time.Duration;

public final class DriverFactory {

    private DriverFactory() {}

    public static AndroidDriver create() {
        try {
            return new AndroidDriver(
                    URI.create(Config.get("appium.url")).toURL(),
                    androidOptions()
            );
        } catch (Exception e) {
            throw new RuntimeException(
                    "Android driver is not created ("
                            + Config.get("appium.url") + ")",
                    e
            );
        }
    }

    private static UiAutomator2Options androidOptions() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(Config.get("android.device"))
                .setUdid(Config.get("android.udid"))
                .setAppPackage(Config.get("android.package"))
                .setNoReset(true)
                .setNewCommandTimeout(
                        Duration.ofSeconds(
                                Config.getInt("new.command.timeout")
                        )
                );

        // Ilovani Appium orqali qayta ishga tushirmaslik
        options.setCapability("appium:autoLaunch", false);

        if (!Config.isBlank("android.app")) {
            options.setApp(Config.get("android.app"));
        }

        if (!Config.isBlank("android.activity")) {
            options.setAppActivity(Config.get("android.activity"));
        }

        return options;
    }
}
