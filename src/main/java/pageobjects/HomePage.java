package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjectsBase {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(partialLinkText="Home")
	public WebElement homeTitle; 

	@FindBy(id ="userNavigationLabel")
	WebElement logOutMenuButton;


	@FindBy(partialLinkText="Log Out")
	WebElement logOutButton;


	public void clickOnLogoutMenu()
	{
		clickOnButton(logOutMenuButton);
	}

	public void clickOnLogoutButton()
	{
		clickOnButton(logOutButton);
	}

}