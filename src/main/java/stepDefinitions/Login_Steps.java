package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

import java.awt.*;
import java.io.IOException;


public class Login_Steps extends DriverFactory {

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() throws IOException {
        login_page.getLoginPage();
    }

    @When("I enter a username {word}")
    public void i_enter_a_unique_username(String username) throws Exception {
        login_page.enterUsername(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) throws Exception {
        login_page.enterPassword(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() throws Exception {
        login_page.clickOnLoginButton();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() throws IOException, InterruptedException, AWTException {
        Thread.sleep(5000);
        login_page.check_successful_login_message_is_displayed();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() throws IOException, InterruptedException, AWTException {
        login_page.check_unsuccessful_login_message_is_displayed();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) throws IOException, InterruptedException, AWTException {
        login_page.check_expected_validation_message_is_displayed(expectedMessage);
    }
}
