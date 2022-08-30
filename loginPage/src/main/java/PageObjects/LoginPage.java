package PageObjects;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	Page page;
	String UserNameTxtBox ="[placeholder=\"e\\.g\\. email\\@domain\\.com\"]";
	String passwordTxtBox =  "input[name=\"password\"]";
	String LoginBtn = "button:has-text(\"Log in\")";
	String forgotPasswordLnk = "text=Forgot your password";
	String CreateAccountLnk = "text=Don't have account?";
	String pageTittle = "text=Please log in to your account";
	String inboxPage = "button:has-text('Saravanan Testing')";
	String errorMessageForInvalidEmail = "text=Validation error";
	String errorMessageForIncorrectEmail ="text=Email address and password does not match";
	String resetPassworBtn = "text=Reset Password";
String profileBtn = ".ProfileOpener > .IconSVG > svg";
String signoutBtn = "text=Logout";
	public LoginPage(Page page) {
		this.page = page;
	}
	public String getLoginTitlePage() {
		return page.title();
	}
	public String getLoginPageUrl() {
		return page.url();
	}
	public String loginWithValidCredentials(String userName, String password) {
		page.fill(UserNameTxtBox, userName);
		page.fill(passwordTxtBox, password);
		page.click(LoginBtn);
		return page.textContent(inboxPage);
	}
	public void signOutAction() {
	page.click(profileBtn);	
	page.click(signoutBtn);
	return;
	}

public void loginWithInalidCredentials(String userName, String password) {
	page.fill(UserNameTxtBox, userName);
	page.fill(passwordTxtBox, password);
	page.click(LoginBtn);
	
}
	public String getErrorMessage() {
	return	page.textContent(errorMessageForIncorrectEmail);
     		
	}
	public void forgotPasswor(String userName) {
		page.click(forgotPasswordLnk);
		page.fill(UserNameTxtBox, userName);
		page.click(resetPassworBtn);
	}
	
}
