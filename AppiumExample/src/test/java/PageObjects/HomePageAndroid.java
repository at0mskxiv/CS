package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 2023-01-13.
 */
public class HomePageAndroid implements HomePage {

    public HomePageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement picnicLogo;

    @AndroidFindBy( accessibility = "Picnic")
    private WebElement logoText;

    @AndroidFindBy(accessibility = "dive into communities ✌️")
    private WebElement taglineText;

    @AndroidFindBy(accessibility = "get started")
    private WebElement getStartedButton;

    @AndroidFindBy(accessibility = "already have an account?")
    private WebElement loginPrompt;

    @AndroidFindBy(accessibility = "login")
    private WebElement loginButton;


    public void assertPicnicLogo() {
        picnicLogo.isDisplayed();
    }

    public void assertPicnicText(String ex) {
        Assert.assertEquals(ex, logoText.getAttribute("content-desc"));
    }

    public void assertTaglineTextPresented() {
        Assert.assertTrue(taglineText.isDisplayed());
        Assert.assertEquals(taglineText.getAttribute("content-desc"), "dive into communities ✌️");
    }

    public void assertGetStartedButtonPresented() {
        Assert.assertTrue(getStartedButton.isDisplayed());
        Assert.assertTrue(getStartedButton.isEnabled());
    }

    public void assertLoginPrompt() {
        Assert.assertTrue(loginPrompt.isDisplayed());
        Assert.assertEquals(loginPrompt.getAttribute("content-desc"), "already have an account?");
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
