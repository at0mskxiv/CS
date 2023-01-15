package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 2023-01-13.
 */
public class MainPageIOS implements MainPage {

    public MainPageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "chat feed")
    private WebElement chatFeed;

    @iOSXCUITFindBy(accessibility = "my circles")
    private WebElement myCircles;

    public void assertChatFeedTab() {
        Assert.assertTrue(chatFeed.isDisplayed());
    };

    public void assertMyCirclesTab() {
        Assert.assertTrue(myCircles.isDisplayed());
    };
}
