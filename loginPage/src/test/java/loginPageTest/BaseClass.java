package loginPageTest;


import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForURLOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.LoadState;

public class BaseClass {

	//private static final String public = null;
	//private static final String Chromium = null;
	
	// TODO Auto-generated method stub

	static Playwright playwright = null;
	static BrowserContext browserContext = null;
	static Browser browser;
static Page page = null;

	public static Page initBrowser(String browserName) throws InterruptedException {
		
		
		System.out.println("Browser name is :"+browserName);
		playwright= Playwright.create();
		    switch (browserName.toLowerCase()) {
			case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "firefox":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "safari":
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "Chrome":
				browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
				break;

			default:
				System.out.println("Please pass the right browser name...");
				break;
		    }

		    	 browserContext = browser.newContext();
				    page = browserContext.newPage();
				  //page.click("button") # click triggers navigation.
					 page.setDefaultNavigationTimeout(1000000);

				   page.navigate("https://stage.outreach.sloovi.com/login");

				    return page;
				    	
					/*
					 * } public void BasePage() { this.page=page; } public String
					 * getLoginPageTitle() { return page.title(); } public String GetLoginPageUrl()
					 * { return page.url();
					 */}
		    }
	 
