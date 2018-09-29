package pageobjects;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AS {
	public static WebDriver driver ;

	@Test
	public void start() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://www.amazon.com");
		//driver.navigate().to("https://www.amazon.com/Childrens-Books/b/ref=nav_shopall_cbo_t3?ie=UTF8&node=4");

		WebElement depMenu = driver.findElement(By.id("nav-link-shopall"));
		WebElement boolsMen = driver.findElement(By.xpath("//span[@class='nav-text'][contains(text(),'Books ')]"));
		WebElement childBooksMenu = driver.findElement(By.xpath(" //span[@class='nav-text'][contains(text(), 'Children')]"));



		Actions perform = new Actions(driver);


		perform.moveToElement(depMenu).perform();

		perform.moveToElement(boolsMen).perform();

		perform.moveToElement(childBooksMenu).click().perform();



		WebElement ageFilter = driver.findElement(By.linkText("Ages 9-12 Years Old"));
		ageFilter.click();


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 2500)");


		if ( !driver.findElement(By.name("s-ref-checkbox-3291437011")).isSelected() )
		{
			driver.findElement(By.name("s-ref-checkbox-3291437011")).click();
		}

		driver.findElement(By.linkText("To All the Boys I've Loved Before")).click();
		driver.findElement(By.id("add-to-cart-button")).click();

		js.executeScript("scrollBy(0, 1000)");

		WebElement secondItem = driver.findElement(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/images/I/518WDIwqi5L._AC_SL230_.jpg']"));
		//WebElement clicksecondItem = driver.findElement(By.xpath("//input[@name ='submit.addToCart']"));

		perform.moveToElement(secondItem).click().perform();


		driver.findElement(By.id("add-to-cart-button")).click();

		js.executeScript("scrollBy(0, 1200)");



		WebElement thirddItem = driver.findElement(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/images/I/51-G1oBxtsL._AC_SL230_.jpg']"));
		//WebElement clicksecondItem = driver.findElement(By.xpath("//input[@name ='submit.addToCart']"));

		perform.moveToElement(thirddItem).click().perform();


		driver.findElement(By.id("add-to-cart-button")).click();

		//	   WebElement image= driver.findElement(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/images/I/51-G1oBxtsL._AC_SL230_.jpg')"));
		//	   perform.moveToElement(image).perform();
		//driver.findElement(By.name("submit.addToCart")).click

		WebElement buttonCount = driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']"));

		Assert.assertEquals(buttonCount.getText(),"Proceed to checkout (3 items)");
		System.out.println(buttonCount.getText());
		WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
		cartButton.click();


		WebElement firstItemCart = driver.findElement(By.linkText("P.S. I Still Love You (To All the Boys I've Loved Before)"));
		System.out.println(firstItemCart.getText());

		WebElement secondItemCart = driver.findElement(By.linkText("Always and Forever, Lara Jean (To All the Boys I've Loved Before)"));
		System.out.println(secondItemCart.getText());

		WebElement thirdItemCart = driver.findElement(By.linkText("To All the Boys I've Loved Before"));
		System.out.println(thirdItemCart.getText());

		WebElement firstItemPrice = driver.findElement(By.xpath("//div[@data-asin='1442426748']//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']"));
		System.out.println(firstItemPrice.getText());

		WebElement secondtItemPrice = driver.findElement(By.xpath("//div[@data-asin='1481430491']//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']"));
		System.out.println(secondtItemPrice.getText());

		WebElement thirdItemPrice = driver.findElement(By.xpath("//div[@data-asin='1442426713']//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']"));
		System.out.println(thirdItemPrice.getText());

		WebElement firstItemQuantity = driver.findElement(By.id("a-autoid-0-announce"));
		System.out.println(firstItemQuantity.getText());

		WebElement secondItemQuantity = driver.findElement(By.id("a-autoid-2-announce"));
		System.out.println(secondItemQuantity.getText());

		WebElement thirdItemQuantity = driver.findElement(By.id("a-autoid-4-announce"));
		System.out.println(thirdItemQuantity.getText());

		WebElement subTotal = driver.findElement(By.xpath("//span[@class ='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']"));
		System.out.println(subTotal.getText());

//
//		Assert.assertEquals(firstItemCart.getText(),"P.S. I Still Love You (To All the Boys I've Loved Before)");
//		Assert.assertEquals(secondItemCart.getText(),"Always and Forever, Lara Jean (To All the Boys I've Loved Before)");
//		Assert.assertEquals(thirdItemCart.getText(),"To All the Boys I've Loved Before");
//		Assert.assertEquals(firstItemPrice.getText(),"$7.60");
//		Assert.assertEquals(secondtItemPrice.getText(),"$7.84");
//		Assert.assertEquals(thirdItemPrice.getText(),"$8.61");
//		Assert.assertEquals(firstItemQuantity.getText(),"1");
//		Assert.assertEquals(secondItemQuantity.getText(),"1");
//		Assert.assertEquals(thirdItemQuantity.getText(),"1");
//		Assert.assertEquals(subTotal.getText(),"$24.05");
//
//
//		if ( !driver.findElement(By.id("sc-buy-box-gift-checkbox")).isSelected() )
//		{
//			driver.findElement(By.id("sc-buy-box-gift-checkbox")).click();
//		}
//
//		WebElement proceedToCheckOutButton = driver.findElement(By.name("proceedToCheckout"));
//		proceedToCheckOutButton.click();
//
//		WebElement createAnAccountButton = driver.findElement(By.id("createAccountSubmit"));
//		createAnAccountButton.click();
//
//		WebElement signupNameTxt = driver.findElement(By.id("ap_customer_name"));
//		signupNameTxt.sendKeys("ahmed");
//		WebElement signupEmailTxt = driver.findElement(By.id("ap_email"));
//		signupEmailTxt.sendKeys("hadymailamazon@gmail.com");
//		WebElement signupPasswordTxt = driver.findElement(By.id("ap_password"));
//		signupPasswordTxt.sendKeys("P@ssw0rd10");
//		WebElement signupRePasswordTxt = driver.findElement(By.id("ap_password_check"));
//		signupRePasswordTxt.sendKeys("P@ssw0rd10");
//		WebElement signupButton = driver.findElement(By.id("continue"));
//		signupButton.click();
//
//		WebElement signupWithAnotherEmailLink = driver.findElement(By.linkText("a different e-mail address"));
//		signupWithAnotherEmailLink.click();
//
//		WebElement signupNameTxt2 = driver.findElement(By.id("ap_customer_name"));
//		signupNameTxt2.sendKeys("ahmed");
//		WebElement signupEmailTxt2 = driver.findElement(By.id("ap_email"));
//		signupEmailTxt2.sendKeys("amazonselimmail@gmail.com");
//		WebElement signupPasswordTxt2 = driver.findElement(By.id("ap_password"));
//		signupPasswordTxt2.sendKeys("P@ssw0rd10");
//		WebElement signupRePasswordTxt2 = driver.findElement(By.id("ap_password_check"));
//		signupRePasswordTxt2.sendKeys("P@ssw0rd10");
//		WebElement signupButton2 = driver.findElement(By.id("continue"));
//		signupButton2.click();
//
//		driver.navigate().to("https://www.amazon.com");
//
//		WebElement accountMenu = driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account')]"));
//		WebElement myAccountMenu = driver.findElement(By.xpath("//span[@class='nav-text'][contains(text(),'Your Account')]"));
//
//
//		perform.moveToElement(accountMenu).perform();
//
//		perform.moveToElement(myAccountMenu).click().perform();
//
//
//
//
//		//		String url = getCurrentURL();  
//		//		     System.out.println("SHOPPING_CART_REVIEW_PAGE: Verifying that we are on SHOPPING_CART_REVIEW_PAGE.");  
//		//		      if (!url.contains("view")){  
//		//		        throw new TestException("ERROR: Not on SHOPPING_CART_REVIEW_PAGE! URL: " + url);  
//		//		      }  
//		//	}
	}




}
