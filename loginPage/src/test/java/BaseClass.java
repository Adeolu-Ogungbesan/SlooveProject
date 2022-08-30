import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {

	private static final String Chromium = null;
	
	// TODO Auto-generated method stub

	static Playwright playwright = null;
	BrowserContext browserContext = null;
	Browser browser = null;
static Page page = null;
@BeforeClass
	public Page setup(String browserName) {
		    Playwright.create();
		    switch (browserName.toLowerCase()) {
			case "Chromium":
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
		    page.navigate("https://stage.outreach.sloovi.com/login");
		    return page;
		    }
	 }
