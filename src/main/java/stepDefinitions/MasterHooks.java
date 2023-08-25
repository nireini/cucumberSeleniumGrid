package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.BasePage;
import utils.ConfigFileImpl;
import utils.DriverFactory;
import utils.IConfigService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MasterHooks extends DriverFactory {

	public IConfigService configService;
	
	@Before
	public void setup() throws IOException {
		configService = new ConfigFileImpl();


		driver = getDriver();

	}
	
	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			if(driver != null && scenario.isFailed()) {
				//scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				BasePage.captureScreenshot();
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
			if(driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
}
}
