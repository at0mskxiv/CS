package PageObjects;

/**
 * Created by Ivan on 2023-01-13.
 */
public interface LoginPage {

    void clickCountryPrefixCode();

    void typePhoneNumber(String phoneNumber);

    void clickContinueButton();

    void assertErrorPopUpPresented();

    void assertErrorPopUpText();

    void assertOKButtonOnErrorPopUpPresented();

    void clickOKButton();

    void assertPhoneNumberTextFieldPresented(String phoneNumber);

    void typeOTP(String otp);

    void typeTextIntoEditTextElement(String text);

    void selectCountryCode(String codeWithCountryName);

    void assertverificationCodeTextPresented();

    void clickOnSuggestion();
}
