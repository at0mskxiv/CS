package Test;

import AppiumSupport.AppiumBaseClass;
import PageObjects.*;
import org.junit.After;
import org.junit.Before;

import AppiumSupport.AppiumController;

/**
 * Created by Ivan on 2023-01-13.
 */
public class BaseTestClass extends AppiumBaseClass{
    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;

    @Before
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID, ANDROID_BROWSERSTACK -> {
                homePage = new HomePageAndroid(driver());
                loginPage = new LoginPageAndroid(driver());
                mainPage = new MainPageAndroid(driver());
            }
            case IOS, IOS_BROWSERSTACK -> {
                homePage = new HomePageIOS(driver());
                loginPage = new LoginPageIOS(driver());
                mainPage = new MainPageIOS(driver());
            }
        }
    }

    @After
    public void tearDown() {
        AppiumController.instance.stop();
    }
}
