package uz.agro.core;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class Gestures {
    private final AndroidDriver driver;
    private final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    public Gestures(AndroidDriver driver) {
        this.driver = driver;
    }

    public void swipeUp() {
        swipe(0.5, 0.75, 0.5, 0.25);
    }

    public void swipeDown() {
        swipe(0.5, 0.25, 0.5, 0.75);
    }

    public void swipeLeft() {
        swipe(0.8, 0.5, 0.2, 0.5);
    }

    public void swipeRight() {
        swipe(0.2, 0.5, 0.8, 0.5);
    }

    public void swipe(double startXRatio, double startYRatio, double endXRatio, double endYRatio) {
        Dimension size = driver.manage().window().getSize();
        Point start = new Point((int) (size.width * startXRatio), (int) (size.height * startYRatio));
        Point end = new Point((int) (size.width * endXRatio), (int) (size.height * endYRatio));

        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    public void tap(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int x = location.x + size.width / 2;
        int y = location.y + size.height / 2;

        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
    }

    public WebElement scrollToText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"
        ));
    }
}
