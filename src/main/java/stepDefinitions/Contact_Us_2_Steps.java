package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.lang.RandomStringUtils;

import java.io.IOException;

import static utils.DriverFactory.contact_us2_Page;

public class Contact_Us_2_Steps {

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    @Given("I access the webdriver university contact us page2")
    public void i_access_the_webdriver_university_contact_us_page() throws IOException {
        contact_us2_Page.getContactUsPage2();
    }

    @When("I enter a unique first name {word}")
    public void i_enter_a_unique_first_name_joe(String firstName) {
        System.out.println("firstName: " + firstName);
      //  driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name {word}")
    public void i_enter_a_unique_last_name(String lastName) {
        System.out.println("lastName: " + lastName);
       // driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email Joe_blogs123@mail.com")
    public void i_enter_a_unique_email_address() {
        System.out.println("Test4");
    }

    @And("I enter a unique comment {string}")
    public void i_enter_a_unique_comment(String comment) {
        System.out.println("comment: " + comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        System.out.println("Test6");
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        System.out.println("Test7");
    }
}
