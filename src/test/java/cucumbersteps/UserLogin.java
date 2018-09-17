package cucumbersteps;

import org.testng.Assert;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testcases.TestCasesBase;

public class UserLogin extends TestCasesBase {
	
	LoginPage loginPageObject;
	HomePage homePageObject;
	SignupPage signupPageObject;
	
	
	@Given("^User on login page$")
	public void user_on_login_page() 
	{
		signupPageObject = new SignupPage(driver);
		Assert.assertTrue(signupPageObject.loginTxt.getText().contains("Log In"));
		System.out.println(signupPageObject.loginTxt.getText());
	}

	@When("^I entred \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_entred(String email, String password) 
	{
		loginPageObject = new LoginPage(driver);
		loginPageObject.validloginToFacebook(email, password);
	}
	
	@When("^I logout from facebook$")
	public void i_logout_from_facebook() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.clickOnLogoutMenu();
		homePageObject.clickOnLogoutButton();
	}

	@Then("^logout and naviagte to home page$")
	public void logout_and_naviagte_to_home_page() 
	{
		Assert.assertTrue(signupPageObject.loginTxt.getText().contains("Log In"));
		System.out.println(signupPageObject.loginTxt.getText());
	}


	
}
