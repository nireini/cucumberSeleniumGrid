package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/java/resources/features/"}, glue = {"stepDefinitions"},
		tags = "@contact-us2", monochrome = true, dryRun = false,
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}