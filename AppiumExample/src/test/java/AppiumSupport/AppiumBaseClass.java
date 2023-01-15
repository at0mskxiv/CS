package AppiumSupport;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Ivan on 2023-01-13.
 */
public class AppiumBaseClass {

    protected AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
}
