package taskPage;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import PageObjects.LoginPage;
import PageObjects.OppotunityPage;
import PageObjects.TaskPage;
import loginPageTest.BaseClass;
import loginPageTest.TestCase_001_1;

public class TestCase_002_3 {
	
	static Page page;
	static BaseClass bc;
	static TaskPage tp;
	static LoginPage lp;
	static OppotunityPage op;
	@BeforeTest
	public void setup() throws InterruptedException {
		bc = new BaseClass();
		page = BaseClass.initBrowser("chromium");
		tp = new TaskPage(page);
		lp = new LoginPage(page);
	}
	
	
@Test(priority = 1)
public void LinkShouldRedirectToTaskPageTC0021() {
	lp = new LoginPage(page);
	lp.loginWithValidCredentials("smithwills1989@gmail.com", "12345678");
	page.navigate("https://stage.outreach.sloovi.com/lead/lead_7e0ce02cc9854ceeb61ea58bbae3f2b6");
	String pagetitle =tp.getPageTitle();
	Assert.assertEquals(pagetitle, "text=boost Pipelin");
}
@Test(priority = 2)
public void editAccountProfile() {
	op = new OppotunityPage(page);
	//op.ClickAccountButton();
	op.eneterUserDetails("Adeolu", "Ogungbesan", "+2348075917711");
	 op.saveProfile();
}
@Test
public void edithSalePipeline() {
	op = new OppotunityPage(page);
	op.salePipeline();
}
}
