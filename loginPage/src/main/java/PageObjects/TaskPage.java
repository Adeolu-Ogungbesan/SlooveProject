package PageObjects;

import com.microsoft.playwright.Page;

public class TaskPage {

	Page page;
	
	String TaskPageTitle = "button:has-text('Saravanan Testing')";
String FollowupTexT = "[data-test-id=\"task_0af24d60215c4d568355eecf554afcba\"] >> text=FollowupTest";
String newTaskBtn = "[data-testid=\'add-task\']";
String TaskDescriptionTXTBox = "[placeholder=\"Description of task\"]";
String CallenderDropdown = "[placeholder=\"MM\\/DD\\/YYYY\"]";
//String TaskDate = "[aria-label=\\\"Thursday\\\\, September 15\\\\, 2022\\\"]";
String TimeDropDown = "[placeholder=\"Time\"]";
String TaskTime = "text=3:00am";
String assignUserTxtBox = "input[name=\"assigned_user\"]";
String assigneeName = "text=Sundar Pichai";
String cancelBtn = "text=Cancel";
String SaveBtn = "text=Save";
String requiredMessage = "text=Required";
String pastDate ="[aria-label=\\\"Friday\\\\, September 2\\\\, 2022\\\"]";
String taskName = "text=New Task";
public TaskPage(Page page) {
	this.page = page;

}

public String getPageTitle() {
	return page.title();
			
	
}

public String getTaskPageUrl() {
	return page.url();
}
public void CreateTask(String tastTitle) {
	page.click(newTaskBtn);
	page.fill(TaskDescriptionTXTBox, " ");
	page.fill(TaskDescriptionTXTBox, "tastTitle");
	page.fill(CallenderDropdown, "09/15/2022");
	//page.click(TaskDate);
	page.click(TimeDropDown);
	page.click(TaskTime);
	page.click(assignUserTxtBox);
	page.click(assigneeName);
	page.click(SaveBtn);
}
public boolean CreateTaskForAPastDate(String tastTitle) {
	page.click(newTaskBtn);
	page.fill(TaskDescriptionTXTBox, " ");
	page.fill(TaskDescriptionTXTBox, "tastTitle");
	page.fill(CallenderDropdown, "09/01/2022");
	//page.click(pastDate);
	page.click(TimeDropDown);
	page.click(TaskTime);
	page.click(assignUserTxtBox);
	page.click(assigneeName);
	page.click(SaveBtn);
	page.hover(tastTitle);
	boolean dueTast = page.isHidden(tastTitle);
	return dueTast;
}

public void CreateTaskWithoutDescritpption() {
	page.click(newTaskBtn);
	page.fill(TaskDescriptionTXTBox, " ");
	page.fill(CallenderDropdown, "09/15/2022");
	//page.click(TaskDate);
	page.click(TimeDropDown);
	page.click(TaskTime);
	page.click(assignUserTxtBox);
	page.click(assigneeName);
	page.click(SaveBtn);

}
public String RequiredTxt() {
	return page.textContent(requiredMessage);
}
public void cancelButtonWhenCreatingATask() {
	page.click(newTaskBtn);
	page.fill(TaskDescriptionTXTBox, " ");
	page.fill(TaskDescriptionTXTBox, "tastTitle");
	page.click(CallenderDropdown);
	//page.click(TaskDate);
	page.click(TimeDropDown);
	page.click(TaskTime);
	page.click(assignUserTxtBox);
	page.click(assigneeName);
	page.click(cancelBtn);

}
public void editATAsk() {
	
}

}