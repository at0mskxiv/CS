package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 2023-01-13.
 */
public class MainPageAndroid implements MainPage {

    public MainPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "chat feed")
    private WebElement chatFeed;

    @AndroidFindBy(accessibility = "my circles")
    private WebElement myCircles;

    public void assertChatFeedTab() {
        Assert.assertTrue(chatFeed.isDisplayed());
    };

    public void assertMyCirclesTab() {
        Assert.assertTrue(myCircles.isDisplayed());
    };
}
