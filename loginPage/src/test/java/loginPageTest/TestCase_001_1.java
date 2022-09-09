package loginPageTest;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import PageObjects.LoginPage;

public class TestCase_001_1  {
	static Page page;
	static	BaseClass bc;
	static LoginPage lp;
	@BeforeTest
	public void setup() throws InterruptedException {
		bc = new BaseClass();
		page =BaseClass.initBrowser("Chromium");
		lp = new LoginPage(page);
	}
	@Test (priority = 1)
	public static void loginWithValidCredentialsTC_00011(){
		lp = new LoginPage(page);
		lp.loginWithValidCredentials("smithwills1989@gmail.com", "12345678");
		lp.signOutAction();

	}
	@Test(priority = 2)

	public static void loginWithinvalidUserNameTC_00012(){
		lp = new LoginPage(page);
		lp.loginWithInalidCredentials("smithwills1@gmail.com", "12345678");
	}
	@Test(priority = 3)

	public static void loginWithinvalidPasswordTC_00013(){
		lp = new LoginPage(page);
		lp.getLoginTitlePage();
		lp.loginWithInalidCredentials("smithwills1989@gmail.com", "1234567832"); 

	}
	@Test(priority = 4)

	public static void errorMessageTC_00014(){
		lp = new LoginPage(page);
		lp.getLoginTitlePage();
		lp.loginWithInalidCredentials("smithwills1@gmail.com", "12345678");	
		String errorMessage = lp.getErrorMessage();
		Assert.assertEquals(errorMessage, "The email address and password does not match.");


	}
	@Test(priority = 5)
	public void resetPasswordTC_ooo15() {
		lp.forgotPasswor("smithwills1989@gmail.com");
	}

}




