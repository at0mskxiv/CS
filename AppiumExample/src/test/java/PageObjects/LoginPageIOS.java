package PageObjects;

import AppiumSupport.AppiumController;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Created by Ivan on 2023-01-13.
 */
public class LoginPageIOS implements LoginPage {

    public LoginPageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    private WebElement phoneNumberTextField;

    @iOSXCUITFindBy(id = "continue")
    private WebElement continueButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"+1\"`]")
    private WebElement countryPrefixButton;

    @iOSXCUITFindBy(id = "Error")
    private WebElement errorPopUp;

    @iOSXCUITFindBy(id = "Something went wrong, please try again")
    private WebElement errorPopUpText;

    @iOSXCUITFindBy(id = "OK")
    private WebElement okButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,'verification code')]")
    private WebElement verificationCodeTextField;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'") //TODO:check locator
    private WebElement editTextElement;

    @iOSXCUITFindBy(accessibility = "+995 Georgia")
    private WebElement countryPrefixGeorgia;

    @iOSXCUITFindBy(accessibility = "verification code")
    private WebElement verificationCode;

    @iOSXCUITFindBy(accessibility = "suggestion")
    private WebElement suggestion;

    void tapOnElementWithCoordinates(WebElement webElement){
        int x = webElement.getLocation().getX() + webElement.getSize().getWidth()/2;
        int y = webElement.getLocation().getY() + webElement.getSize().getHeight()/2;

        TouchAction action = new TouchAction((PerformsTouchActions) AppiumController.instance.driver);
        action.press(PointOption.point(x, y));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)));
        action.release();
        action.perform();
    }

    public void clickCountryPrefixCode() {
        tapOnElementWithCoordinates(countryPrefixButton);
    }

    public void typePhoneNumber(String phoneNumber) {
        phoneNumberTextField.sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void assertErrorPopUpPresented() {
        Assert.assertTrue(errorPopUp.isDisplayed());
    }

    public void assertErrorPopUpText() {
        Assert.assertTrue(errorPopUpText.isDisplayed());

    }

    public void assertOKButtonOnErrorPopUpPresented() {
        Assert.assertTrue(okButton.isDisplayed());
        Assert.assertTrue(okButton.isEnabled());
    }

    public void clickOKButton() {
        okButton.click();
    }

    public void assertPhoneNumberTextFieldPresented(String phoneNumber) {
        Assert.assertTrue(phoneNumberTextField.isEnabled());
        Assert.assertEquals(phoneNumberTextField.getText(), phoneNumber);
    }

    public void typeOTP(String otp) {
        verificationCodeTextField.sendKeys(otp);
    }

    public void typeTextIntoEditTextElement(String text) {
        tapOnElementWithCoordinates(editTextElement);
        editTextElement.sendKeys(text);
    }

    public void selectCountryCode(String codeWithCountryName) {
        tapOnElementWithCoordinates(countryPrefixGeorgia);
    }

    public void assertverificationCodeTextPresented() {
        Assert.assertTrue(verificationCode.isDisplayed());
    }

    public void clickOnSuggestion() {
        suggestion.click();
    }
}
