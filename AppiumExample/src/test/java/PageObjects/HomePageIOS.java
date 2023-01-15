package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 2023-01-13.
 */
public class HomePageIOS implements HomePage {

    public HomePageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeImage\"")
    private WebElement picnicLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Picnic\"]")
    private WebElement logoText;

    @iOSXCUITFindBy(id = "dive into communities ✌️")
    private WebElement taglineText;

    @iOSXCUITFindBy(id = "get started")
    private WebElement getStartedButton;

    @iOSXCUITFindBy(id = "already have an account?")
    private WebElement loginPrompt;

    @iOSXCUITFindBy(id = "login")
    private WebElement loginButton;

    public void assertPicnicLogo() {
        picnicLogo.isDisplayed();
    }

    public void assertPicnicText(String ex) {
        Assert.assertEquals(ex, logoText.getText());
    }

    public void assertTaglineTextPresented() {
        Assert.assertTrue(taglineText.isDisplayed());
        Assert.assertEquals(taglineText.getText(), "dive into communities ✌️");
    }

    public void assertGetStartedButtonPresented() {
        Assert.assertTrue(getStartedButton.isDisplayed());
        Assert.assertTrue(getStartedButton.isEnabled());
    }

    public void assertLoginPrompt() {
        Assert.assertTrue(loginPrompt.isDisplayed());
        Assert.assertEquals(loginPrompt.getText(), "already have an account?");
    }

    public void assertLoginButtonPresented() {
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
    }

    public void clickGetStartedButton() {
        getStartedButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
