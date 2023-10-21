package hooks;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static WebDriver driver;
	private static DriverFactory df;
	
	@BeforeAll
	public static void setUp()
	{
		df=new DriverFactory();
		df.initializeDriver("chrome");
	}
	@Before
	public void beforescenario(Scenario scenario)
	{
		System.out.println(scenario.getSourceTagNames()+":"+scenario.getName());
	}
	
	@AfterAll
	public static void tearDown()
	{
		df.closeDriver();
	}
	public static WebDriver getDriver() {
		return driver;
	}

}
