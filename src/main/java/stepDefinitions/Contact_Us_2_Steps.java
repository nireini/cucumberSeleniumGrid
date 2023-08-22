package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static utils.DriverFactory.contact_us2_Page;

public class Contact_Us_2_Steps {

//    private WebDriver driver;

//    @Before
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() throws IOException {
        contact_us2_Page.getContactUsPage2();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        System.out.println("Test2");
      //  driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        System.out.println("Test3");
       // driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        System.out.println("Test4");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        System.out.println("Test5");
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
