package PageObjects;

import com.microsoft.playwright.Page;

public class OppotunityPage {

	Page page;
	
	String opportunityPageTitle = "text=boost Pipeline";
String expectedDropdown = "button:has-text(\\\"Expected: All Time\\\")";
String labelExpected = "\"label:has-text(\\\"Expected\\";
String allTime = "\"#tippy-187 >> text=All Time";
String boostDropDown = "button:has-text(\"boost\")";
//String TaskDate = "[aria-label=\\\"Thursday\\\\, September 15\\\\, 2022\\\"]";
String managePipeline = "text=Manage Pipeline";
String statusNamePlaceHolder = "text=Add1Potential2Bad Fit3Qualified4Customer5Interested6Cancelled7Not Interested >> [placeholder=\\\"Status Name\\\"]";
String addButton = "text=Add";
String accountBar = "text=Account";
String FirstName = "input[name='firstName']";
String LastName = "input[name='lastName']";
String Phone = "input[name='phone']";
String saveBtn ="text=Save Profile";
String opportunityMenu = "nav >> text=Opportunities";
String SalesMenu = "li:has-text('Sales')";
String editSales = "text=Interview$0 One Time50% on 2022-07-22 >> button";
public OppotunityPage(Page page) {
	this.page = page;

}

public String getPageTitle() {
	return page.title();
			
	
}

public String getTaskPageUrl() {
	return page.url();
}
public void ClickAccountButton () {
		page.click(accountBar);
		
}
public void eneterUserDetails(String firstName, String lastName, String phone) {
	page.click(opportunityMenu);
	page.click(boostDropDown);
	page.click(managePipeline);
	page.click(accountBar);
	page.fill(FirstName,firstName );
	page.fill(LastName, lastName);
	page.fill(Phone, phone);
	
}
public void saveProfile() {
	page.click(saveBtn);
	
}
public void salePipeline() {
	page.click(boostDropDown);
	page.click(SalesMenu);
	page.click(editSales);
}
}