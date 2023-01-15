package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ivan on 2023-01-13.
 */
public class LoginPageAndroid implements LoginPage {

    public LoginPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement phoneNumberTextField;

    @AndroidFindBy(accessibility = "continue")
    private WebElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='+1']")
    private WebElement countryPrefixButton;

    @AndroidFindBy(accessibility = "Error")
    private WebElement errorPopUp;

    @AndroidFindBy(accessibility = "Something went wrong, please try again")
    private WebElement errorPopUpText;

    @AndroidFindBy(accessibility = "OK")
    private WebElement okButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement verificationCodeTextField;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement editTextElement;

    @AndroidFindBy(accessibility = "+995 Georgia")
    private WebElement countryPrefixGeorgia;

    @AndroidFindBy(accessibility = "verification code")
    private WebElement verificationCode;

    @iOSXCUITFindBy(accessibility = "suggestion")
    private WebElement suggestion;

    public void clickCountryPrefixCode() {
        countryPrefixButton.click();
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
        editTextElement.click();
        editTextElement.sendKeys(text);
    }

    public void selectCountryCode(String codeWithCountryName) {
        countryPrefixGeorgia.click();
    }

    public void assertverificationCodeTextPresented() {
        Assert.assertTrue(verificationCode.isDisplayed());
    }

    public void clickOnSuggestion() {
        suggestion.click();
    }
}
