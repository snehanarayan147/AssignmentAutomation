package qualicoach;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class Login  extends Base {
	WebDriver driver = null;

	@BeforeTest
	public void testLogin() {
		driver = initializeDriver();
	}


	@Test
	public void LoginTest() {
		driver.manage().window().maximize();
		driver.get("https://test.qualicoach.org/my/");

		// login page
		LoginPage login = new LoginPage(driver);
		login.getUsername().sendKeys("user101");
		login.getPassword().sendKeys("User@6177");
		login.loginBtn().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}


	
		
	}


