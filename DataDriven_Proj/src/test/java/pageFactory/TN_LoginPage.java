package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import utilities.ConfigReader;

public class TN_LoginPage {

	public static WebDriver driver = DriverFactory.getDriver();

	public TN_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title=\"My Account\"]")
	WebElement myAccount;

	@FindBy(xpath = "//*[text()=\"Login\"]")
	WebElement loginLink;

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-password")
	WebElement passwordField;

	@FindBy(xpath = "//*[@value=\"Login\"]")
	WebElement LoginButton;

	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement logoutButton;

	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement accountTitle;

	public void login_Page() {
		driver.get("https://tutorialsninja.com/demo/");
	}

	public void clickOnMyAccount() {
		myAccount.click();
	}

	public void clickOnLoginLink() {
		loginLink.click();
	}

	public void login(String username, String password) {
		emailField.clear();
		emailField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);

	}

	public void clickOnLoginButton() {
		LoginButton.click();
	}

	public void clickOnLogoutButton() {
		//new WebDriverWait(driver,Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(logoutButton));
		logoutButton.click();
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public void login_With_PropertyfileData() throws IOException {

		Properties prop = ConfigReader.intializeProperties();
		emailField.clear();
		emailField.sendKeys(prop.getProperty("email_address"));
		passwordField.clear();
		passwordField.sendKeys(prop.getProperty("password"));
		LoginButton.click();
	}
	
	public void login_With_Excel(String username,String password)
	{
		emailField.sendKeys(username);
		passwordField.sendKeys(password);
		
	}
	public void login_With_DataTable(String username,String password)
	{
		emailField.sendKeys(username);
		passwordField.sendKeys(password);

	}

}
