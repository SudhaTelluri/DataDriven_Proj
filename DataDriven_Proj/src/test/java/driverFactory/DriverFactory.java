package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver initializeDriver(String browser) 
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

//right click go to source generate getter method for driver
	public static WebDriver getDriver() 
	{
		return driver;
	}

	public void closeDriver() 
	{
		driver.close();
	}
}
