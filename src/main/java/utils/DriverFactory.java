package utils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

public class DriverFactory {
	public static WebDriver driver;
	public static ContactUs_Page contactUsPage;
	public static Products_Page productsPage;
	public static Contact_Us2_Page contact_us2_Page;

	public static Contact_Us_3_Page contact_us_3_page;
	public static Crossword_Page crossword_Page;

	public static Login_Page login_page;



	public WebDriver getDriver() {
		try {
			// Read Config
			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");
			String useGrid = p.getProperty("useGrid");
			Boolean useGridBoolean = Boolean.valueOf(useGrid);

			if(useGridBoolean) 
			{
				
				switch(browserName) {
				
				case "chrome":
					if (null == driver) 
					{

						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
						chromeOptions.addArguments("--remote-allow-origins=*");

					URL url_chrome = new URL("http://localhost:4444/");
					driver = new RemoteWebDriver(url_chrome, chromeOptions);
					driver.manage().window().maximize();
					}
				    
				    
	            case "firefox":
					
	            	if (null == driver) 
					{
						FirefoxOptions firefoxOptions = new FirefoxOptions();
						firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
						firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


					URL url_firefox = new URL("http://localhost:4444/");
					driver = new RemoteWebDriver(url_firefox, firefoxOptions);
					driver.manage().window().maximize();
					}
				}  
			}else
			{
				switch (browserName) {

				case "firefox":
					// code
					if (null == driver) {
						System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);

						FirefoxOptions firefoxOptions = new FirefoxOptions();
						firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
						firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

						driver = new FirefoxDriver(firefoxOptions);
						driver.manage().window().maximize();
					}
					break;

				case "chrome":
					// code
					if (null == driver) {
						System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
						chromeOptions.addArguments("--remote-allow-origins=*");

						driver = new ChromeDriver(chromeOptions);
						driver.manage().window().maximize();
					}
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
			productsPage = PageFactory.initElements(driver, Products_Page.class);
			contact_us2_Page = PageFactory.initElements(driver, Contact_Us2_Page.class);
			contact_us_3_page = PageFactory.initElements(driver, Contact_Us_3_Page.class);
			crossword_Page = PageFactory.initElements(driver, Crossword_Page.class);
			login_page = PageFactory.initElements(driver, Login_Page.class);
		}
		return driver;
	}
}
