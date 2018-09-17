package cucumbersteps;

import org.testng.Assert;

import pageobjects.ConfirmPage;
import pageobjects.HomePage;
import pageobjects.SignupPage;
import testcases.TestCasesBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserSignup  extends TestCasesBase{

	SignupPage signupPageObjects;
	ConfirmPage confirmPageObject;
	HomePage homePageObject;

	@Given("^user on signup page$")
	public void user_on_signup_page() 
	{
		signupPageObjects = new SignupPage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
	}

	@When("^i entred \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", "
			+ "\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" \"([^\"]*)\"$")
	public void i_entred(String firstName, String lastName, String email, String password, 
			String day, String month, String year, String gender) 
	{
		signupPageObjects = new SignupPage(driver);
		signupPageObjects.userSignup(firstName, lastName, email, password);
		signupPageObjects.selectBirtdateFromDropdownlist(day,month,year);
		signupPageObjects.selectGenderForSignup(gender);
	}

	@When("^I click on signup button$")
	public void i_click_on_signup_button() 
	{
		signupPageObjects.clickOnSignupButton();
	}

	@Then("^Confirm page dispalyed successfully$")
	public void confirm_page_dispalyed_successfully() 
	{
		confirmPageObject =  new ConfirmPage(driver);
		Assert.assertTrue(confirmPageObject.confirmEmailTitle.getText().contains("Confirm your email address"));
		System.out.println(confirmPageObject.confirmEmailTitle.getText());
	}
}
