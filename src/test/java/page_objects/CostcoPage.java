package page_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CostcoPage {

	// Local Variables
	private WebDriver driver;
	private final String URL = "https://www.costco.com/";
	private final String TITLE_TEXT = "COSTCO WHOLESALE";

	// Elements
	@FindBy(xpath = "//*[@automation-id='headerCostcoLogo']")
	private WebElement titleText;

	// Constructor
	public CostcoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.navigate().to(URL);
	}

	public void validatePageload() {
		assertEquals(TITLE_TEXT, titleText.getText());
	}
}