package taskPage;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import PageObjects.LoginPage;
import PageObjects.TaskPage;
import loginPageTest.BaseClass;
import loginPageTest.TestCase_001_1;

public class TestCase_002_1 {
	
	static Page page;
	static BaseClass bc;
	static TaskPage tp;
	static LoginPage lp;
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
	page.navigate(" https://stage.outreach.sloovi.com/lead/lead_7e0ce02cc9854ceeb61ea58bbae3f2b6");
	String pagetitle =tp.getPageTitle();
	Assert.assertEquals(pagetitle, "Sloovi Outreach");
}
@Test(priority = 2)
public void CreatNewTaskTC0022() {
	tp = new TaskPage(page);
	tp.CreateTask("New Task");
	
}
@Test(priority = 3)
public void taskWithoutDescriptionTC0023() {
	tp = new TaskPage(page);
	tp.CreateTaskWithoutDescritpption();
	String required = tp.RequiredTxt();
	Assert.assertEquals(required, "Required");
}
public void CreateTaskFoAPastDateTC0024() {
	tp = new TaskPage(page);
	tp.CreateTaskForAPastDate("TaskToBeDone");
	
}
public void cancelWhileCreatingANewTAskTC0025() {
	tp = new TaskPage(page);
	tp.cancelButtonWhenCreatingATask();
}
public void editTaskTC0031() {
tp = new TaskPage(page);
tp.editATAsk();
}

}
