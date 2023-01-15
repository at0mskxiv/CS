package PageObjects;

/**
 * Created by Ivan on 2023-01-13.
 */
public interface HomePage {

    void assertPicnicLogo();

    void assertPicnicText(String logoText);

    void assertGetStartedButtonPresented();

    void assertTaglineTextPresented();

    void assertLoginPrompt();

    void assertLoginButtonPresented();

    void clickGetStartedButton();

    void clickLoginButton();

}
