package Test;

import AppiumSupport.AppiumBaseClass;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 2023-01-13.
 */
public class Test_Picnic extends BaseTestClass {

    AppiumBaseClass driver = new AppiumBaseClass() {
        @Override
        protected AppiumDriver driver() {
            return super.driver();
        }
    };

    @Test
    public void checkHomePage() {
        //Verify Picnic logo
        homePage.assertPicnicLogo();

        //Verify logo text
        homePage.assertPicnicText("Picnic");

        //Check if get started button displayed and enabled
        homePage.assertGetStartedButtonPresented();

        //Check if tagline text displayed
        homePage.assertTaglineTextPresented();

        //Check if login prompt text displayed
        homePage.assertLoginPrompt();

        //Check if login button is displayed
        homePage.assertLoginButtonPresented();
    }

    @Test
    public void loginWithWrongUser() {
        homePage.clickLoginButton();
        loginPage.typePhoneNumber("5555551234");
        loginPage.clickContinueButton();
        loginPage.assertErrorPopUpPresented();
        loginPage.assertErrorPopUpText();
        loginPage.assertOKButtonOnErrorPopUpPresented();
        loginPage.clickOKButton();
        loginPage.assertPhoneNumberTextFieldPresented("5555551234");
    }

    public String getBody() throws IOException {
    URL url = new URL("https://www.receivesms.co/us-phone-number/3411/");
    URLConnection con = url.openConnection();
    InputStream in = con.getInputStream();
    String encoding = con.getContentEncoding();
    encoding = encoding == null ? "UTF-8" : encoding;
        System.out.println("Triggers getBody");
        return IOUtils.toString(in, encoding);
    }

    public String getOTP() throws IOException {
    // Create a Pattern object
    Pattern r = Pattern.compile("[1 minute ago|\\d\\d sec ago][\\s\\S].+[\\s\\S].+data-clipboard-text=\"(\\d+.)\"><b>\\d+</b></span> is your verification code for Picnic - Dive into Communities.");

    // Now create matcher object.
    Matcher m = r.matcher(getBody());
    String otp = "";

        if (m.find()) {
            otp = m.group(1);
        } else {
            System.out.println("NO MATCH");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Triggers getOTP");
            return otp;
    }

    @Test
    public void registerNewUser() throws IOException {
        homePage.clickGetStartedButton();
        loginPage.clickContinueButton();
        loginPage.typePhoneNumber("2014222730");
        int i = 0;
        String otp = "";
        while (i < 60) {
            otp = getOTP();
            i++;
        }
        loginPage.typeOTP(otp);
        loginPage.clickContinueButton();
    }

    @Test
    public void loginWithNewUser() throws IOException {
        homePage.clickLoginButton();
        loginPage.typePhoneNumber("2014222730");
        loginPage.clickContinueButton();
        int i = 0;
        String otp = "";
        while (i < 60) {
            otp = getOTP();
            i++;
        }
        loginPage.typeOTP(otp);
        loginPage.clickContinueButton();
        }

    @Test
    public void loginWithLocalUser() {
        homePage.clickLoginButton();
        loginPage.clickCountryPrefixCode();
        loginPage.typeTextIntoEditTextElement("+995");
        loginPage.selectCountryCode("+995 Georgia");
        loginPage.typePhoneNumber("555261298");
        loginPage.clickContinueButton();
        loginPage.assertverificationCodeTextPresented();
        loginPage.clickContinueButton();
        loginPage.clickOnSuggestion();
        //Check that user logged in by verifying tabs on main screen
        mainPage.assertChatFeedTab();
        mainPage.assertMyCirclesTab();
    }
}
