package utilities;

import org.openqa.selenium.WebDriver;

import page_objects.*;

public class PageManager {

	private static PageManager pageManager = null;
	private WebDriver driver;
	
	private CostcoPage CostcoPage;
	private Dashboard Dashboard;

	private PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public static PageManager getInstance() {
		if (pageManager == null) {
			pageManager = new PageManager(DriverManager.getInstance());
		}
		return pageManager;
	}

	public static void cleanup() {
		pageManager = null;
	}


	public CostcoPage CostcoPage() {
		if (CostcoPage == null) {
			CostcoPage = new CostcoPage(driver);
		}
		return CostcoPage;
	}

	public Dashboard Dashboard() {
		if (Dashboard == null) {
			Dashboard = new Dashboard(driver);
		}
		return Dashboard;
	}

}
