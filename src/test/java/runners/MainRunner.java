package runners;

import java.io.File;
import java.io.IOException;

import com.vimalselvam.cucumber.listener.Reporter;



import org.junit.runner.RunWith;

import org.testng.annotations.AfterClass;
//import com.cucumber.listener.Reporter;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;

@CucumberOptions(features = {"src/test/java/resources/features/"}, glue = {"stepDefinitions"},
		tags = "", monochrome = true, dryRun = false,
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}