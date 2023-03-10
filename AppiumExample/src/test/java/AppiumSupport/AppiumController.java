package AppiumSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 2023-01-13.
 */
public class AppiumController {

    //Browserstack setup
    private static String BS_USERNAME = "<your_browserstack_username>";
    private static String BS_ACCESSKEY = "<your_browserstack_accesskey>";
    private static String IOS_HASHED_APP_ID = "<your_ios_hashed_appid>";
    private static String ANDROID_HASHED_APP_ID = "<your_android_hashed_appid>";

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS,
        ANDROID_BROWSERSTACK,
        IOS_BROWSERSTACK
    }
    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch(executionOS){
            case ANDROID:
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "NotUsed");
                capabilities.setCapability("appPackage", "com.ambertech.amber");
                capabilities.setCapability("appActivity", "com.ambertech.amber.MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 12 mini");
                capabilities.setCapability("udid", "00008101-000649D62139003A");
                capabilities.setCapability("bundleId", "com.ambertech.amber");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("orientation", "PORTRAIT");

                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case ANDROID_BROWSERSTACK:
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "NotUsed");
                capabilities.setCapability("appPackage", "com.jayway.contacts");
                capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
                capabilities.setCapability("device", "Samsung Galaxy S8");
                capabilities.setCapability("os_version", "7.0");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + ANDROID_HASHED_APP_ID);
                driver = new AndroidDriver(new URL("https://" + BS_USERNAME + ":" + BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
            case IOS_BROWSERSTACK:
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 7");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + IOS_HASHED_APP_ID);
                driver = new IOSDriver(new URL("https://" + BS_USERNAME + ":" + BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

//    public void findElementByXpath(String text) {
//        driver.findElement(By.xpath("//*[@text='" + text + "']"));
//    }
//
//    public void findElementBy(String text) {
//        driver.findElement(By.axpath("//*[@text='" + text + "']"));
//    }
}
