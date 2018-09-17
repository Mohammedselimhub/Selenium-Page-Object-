package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;
import testdata.JsonDataReader;

public class LoginTestCases extends TestCasesBase {

	LoginPage loginPageObject;
	HomePage homePageObject;
	SignupPage signupPageObject;

	//Data driven from JSON file
	@Test(priority = 1, description = " user can login succssfully and logout") 
	public void validLoginToFacebookUsingJSON() throws Exception
	{
		JsonDataReader jasonReader = new JsonDataReader();
		jasonReader.JsonReader();
		loginPageObject = new LoginPage(driver);
		loginPageObject.validloginToFacebook(jasonReader.email, jasonReader.password);
		homePageObject = new HomePage(driver);
		homePageObject.clickOnLogoutMenu();
		homePageObject.clickOnLogoutButton();
		signupPageObject = new SignupPage(driver);
		// assertion after logout, verifying that user now on signup page.
		Assert.assertTrue(signupPageObject.loginTxt.getText().contains("Log In"));
		System.out.println(signupPageObject.loginTxt.getText());
	}

	@Test(priority = 2, description = " user will not logout incase of click on back") 
	public void userWillNotLogoutFromFacebook() 
	{
		loginPageObject = new LoginPage(driver);
		loginPageObject.InvalidLoginToFacebook("P@ssw0rd");
		driver.navigate().back();
		homePageObject = new HomePage(driver);
		// assertion after user click on back button to make sure that user still on home not login screen.  
		Assert.assertTrue(homePageObject.homeTitle.getText().contains("Home"));
		System.out.println(homePageObject.homeTitle.getText());
		homePageObject.clickOnLogoutMenu();
		homePageObject.clickOnLogoutButton();	
	}

	@Test(priority = 3, description = " user can't login with incorect password") 
	public void invalidLoginToFacebookWithInccorectPassword() 
	{
		loginPageObject = new LoginPage(driver);
		loginPageObject.InvalidLoginToFacebook("123456789");
		Assert.assertTrue(loginPageObject.incoorectPasswordMessage.getText().contains("Recover Your Account"));
		System.out.println(loginPageObject.incoorectPasswordMessage.getText());
	}

}
