package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObjectsBase {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id="email")
	WebElement emailTxt; 

	@FindBy(id="pass")
	WebElement passowrdTxt;

	@FindBy(id="loginbutton")
	WebElement loginButton;

	@FindBy (partialLinkText="Recover Your Account")
	public WebElement incoorectPasswordMessage;


	public void validloginToFacebook(String email, String password)
	{
		setTextForElement(emailTxt, email);
		setTextForElement(passowrdTxt, password);
		clickOnButton(loginButton);
	}

	public void InvalidLoginToFacebook(String password)
	{
		setTextForElement(passowrdTxt, password);
		clickOnButton(loginButton);
	}

}
