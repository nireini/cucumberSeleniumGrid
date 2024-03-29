package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/java/resources/features/"}, glue = {"stepDefinitions"},
		tags = "@login", monochrome = true, dryRun = false,
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

}