package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.io.IOException;

public class Login_Page extends BasePage{
    public Login_Page() throws IOException {
        super();
    }

    public @FindBy(id = "text") WebElement textfield_username;

    public @FindBy(id = "password") WebElement textfield_password;

    public @FindBy(id = "login-button") WebElement login_button;

    public Login_Page getLoginPage() throws IOException {
        getDriver().get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
        return new Login_Page();
    }

    public Login_Page enterUsername(String username) throws Exception {
        sendKeysToWebElement(textfield_username, username);
        return new Login_Page();
    }

    public Login_Page enterPassword(String password) throws Exception {
        sendKeysToWebElement(textfield_password, password);
        return new Login_Page();
    }

    public Login_Page clickOnLoginButton() throws Exception {
        click_element("login-button");
        return new Login_Page();
    }

    public Login_Page check_successful_login_message_is_displayed() throws IOException, InterruptedException, AWTException {
        Compare_alert_message_with_expected_message("validation succeeded");
        closeAlertPopupBox();
        return new Login_Page();
    }

    public Login_Page check_unsuccessful_login_message_is_displayed() throws IOException, InterruptedException, AWTException {
        Compare_alert_message_with_expected_message("validation failed");
        closeAlertPopupBox();
        return new Login_Page();
    }

    public Login_Page check_expected_validation_message_is_displayed(String expected_message) throws IOException, InterruptedException, AWTException {
        Compare_alert_message_with_expected_message(expected_message);
        closeAlertPopupBox();
        return new Login_Page();
    }




}
