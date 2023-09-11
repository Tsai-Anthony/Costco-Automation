package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	// Local Variables
	private WebDriver driver;

	// Elements
	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[1]/a")
	private WebElement groceryLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[2]/a")
	private WebElement sameDayLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[3]/a")
	private WebElement dealsLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[4]/a")
	private WebElement businessDeliveryLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[5]/a")
	private WebElement opticalLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[6]/a")
	private WebElement pharmacyLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[7]/a")
	private WebElement servicesLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[8]/a")
	private WebElement photoLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[9]/a")
	private WebElement travelLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[10]/a")
	private WebElement membershipLink;

	@FindBy(xpath = "//*[@id=\"navigation-widget\"]/div/nav/div[11]/a")
	private WebElement locationsLink;

	@FindBy(xpath = "//*[@automation-id='headerCostcoLogo']")
	private WebElement homeLink;

	// Constructor
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void returnHome() {
		homeLink.click();
	}

	public void navigateToGroceryPage() {
		groceryLink.click();
	}

	public void navigateToSameDayPage() {
		sameDayLink.click();
	}

	public void navigateToDealsPage() {
		dealsLink.click();
	}

	public void navigateToBusinessDeliveryPage() {
		businessDeliveryLink.click();
	}

	public void navigateOpticalToPage() {
		opticalLink.click();
	}

	public void navigateToPharmacyPage() {
		pharmacyLink.click();
	}

	public void navigateToServicesPage() {
		servicesLink.click();
	}

	public void navigateToPhotoPage() {
		photoLink.click();
	}

	public void navigateToTravelPage() {
		travelLink.click();
	}

	public void navigateToMembershipPage() {
		membershipLink.click();
	}

	public void navigateToLocationsPage() {

	}
}