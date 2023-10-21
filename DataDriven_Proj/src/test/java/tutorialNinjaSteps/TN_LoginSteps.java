package tutorialNinjaSteps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.TN_LoginPage;
import utilities.ExcelReader;

public class TN_LoginSteps {

	TN_LoginPage loginPage = new TN_LoginPage();

	@Given("User opens tutorial ninja website")
	public void user_opens_tutorial_ninja_website() {
		loginPage.login_Page();
		System.out.println("User is on tutorial ninja homepage");
	}

	@When("User click on MyAccount")
	public void user_click_on_my_account() {
		loginPage.clickOnMyAccount();

	}

	@When("click on Login link")
	public void click_on_login_link() {
		loginPage.clickOnLoginLink();

	}

	@When("User enter the emailaddress and password {string} and {string}")
	public void user_enter_the_emailaddress_and_password_and(String username, String password) {
		loginPage.login(username, password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("User should navigated to account page")
	public void user_should_navigated_to_account_page() {

		String actual = loginPage.getTitleOfPage();
		Assert.assertEquals(actual, "My Account");
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {
		loginPage.clickOnLogoutButton();
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() throws IOException {
		loginPage.login_With_PropertyfileData();
	}

	@When("User enters valid credentials using sheet {string} {int}")
	public void user_enters_valid_credentials_using_sheet(String sheetname, Integer rownum)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("src\\test\\resources\\excel\\Data.xlsx", sheetname);
		String xl_email = testdata.get(rownum).get("email");
		String xl_password = testdata.get(rownum).get("password");
		loginPage.login_With_Excel(xl_email, xl_password);
	}

	@Then("User should logout successfully")
	public void user_should_logout_successfully() {

		String actual = loginPage.getTitleOfPage();
		Assert.assertEquals(actual, "Account Logout");

	}
	@When("User enters the credentails using Data table")
	public void user_enters_the_credentails_using_data_table(DataTable dataTable){
		List<List<String>> data = dataTable.cells();
		loginPage.login_With_DataTable(data.get(0).get(0), data.get(0).get(1));
		
	    	}

}
