package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static utils.DriverFactory.crossword_Page;

public class CrosswordSteps {

    @Given("I access the Daily Quick Crossword page")
    public void I_access_the_Daily_Quick_Crossword_page() throws IOException {
        crossword_Page.getCrosswordPage();
    }

    @When("I click agree button")
    public void I_click_agree_button() throws Exception {
        crossword_Page.clickOnAgreeButton();
    }

    @And("I click play button")
    public void I_click_play_button() throws Exception {
        crossword_Page.clickOnPlayButton();
    }

    @Then("li element present in iframe")
    public void li_element_present_in_iframe() throws Exception {
        crossword_Page.waitForCurrentDayLiElement();
    }
}
