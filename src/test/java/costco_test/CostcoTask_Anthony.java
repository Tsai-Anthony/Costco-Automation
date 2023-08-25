package costco_test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CostcoTask_Anthony extends BaseTest {
	static By homepage_searchBox = By.id("search-field");
	static By PLP_addToCartButtons = By.xpath("//*[contains(@id,'addbutton') and contains(text(),'Add')]");
	static By header_cartNumber = By.xpath("//*[@id='cart-d']/div/div/span");
	static By header_cartLink = By.id("cart-t");
	static By shoppingCart = By.id("cart-title");

	static int totalClicks = 3;
	static String clicks = totalClicks + "";

	public static void main(String[] args) {
		addToCart();
	}

	public static void addToCart() {
		try {

			setUpTest("https://www.costco.com/");
			driver.findElement(homepage_searchBox).sendKeys("chair" + Keys.ENTER);
			List<WebElement> addToCarts = driver.findElements(PLP_addToCartButtons);

			for (int i = 0; i < totalClicks; i++) {
				addToCarts.get(i).click();
				waitForCartTotalUpdate(i + 1);
			}

			String cartTotal = driver.findElement(header_cartNumber).getText();

			if (cartTotal.equals(clicks)) {
				System.out.println("Validation passed \n Cart total: " + cartTotal + "\n Total clicks: " + totalClicks);
			} else {
				Assertions.fail("Cart total is incorrect.");
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
		} finally {
			endTest();
		}
	}

	public static void waitForCartTotalUpdate(int expectedCartTotal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// 15 sec max wait because my laptop is being slow

		wait.until(ExpectedConditions.textToBe(header_cartNumber, String.valueOf(expectedCartTotal)));
		// waiting until text to be present in cart 
		// string to string
	}
}
