package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.BasePage;
import utils.DriverFactory;

import java.sql.Timestamp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() throws Exception {
		driver = getDriver();
	}

	@AfterStep
	public void captureExceptionImage(Scenario scenario) {
		if (scenario.isFailed()) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String timeMilliseconds = Long.toString(timestamp.getTime());

			byte[] screenshot = ((TakesScreenshot) getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", timeMilliseconds);
		}
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
