package costco_test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class CostcoTask_Anthony3 extends BaseTest {
	static By homepage_searchBox = By.id("search-field");
	static By PLP_addToCartButtons = By.xpath("//*[contains(@id,'addbutton') and contains(text(),'Add')]");
	static By header_cartNumber = By.xpath("//*[@id='cart-d']/div/div/span");
	static By header_cartLink = By.id("cart-t");
	static By shoppingCart = By.id("cart-title");

	static int totalClicks = 3;
	static String clicks = totalClicks + "";
	//hello im not able to go on costco to validate if this code works
	//i believe because the schools wifi is blocked
	//this is another way to handle wait 
	//earlier i used wait.until(ExpectedCondition)
	//this is waits for the element to appear 
	//it encapsulate the condition and makes it look cleaner
	
	//but this is another approach where i didnt use wait.until(ExpectedCondition)
	//i used a while loop to check repeatedly if the element updates
	//check if they do
	//then pass the next regular loop

	public static void main(String[] args) {
		addToCart();
	}

	public static void addToCart() {
		try {
			setUpTest("https://www.costco.com/");
			driver.findElement(homepage_searchBox).sendKeys("chair" + Keys.ENTER);
			List<WebElement> addToCarts = driver.findElements(PLP_addToCartButtons);

			for (int i = 0; i < totalClicks; i++) {
				long startTime = System.currentTimeMillis();
				// print the start time
				addToCarts.get(i).click();
				waitForCartTotalUpdate(i + 1);
				long endTime = System.currentTimeMillis();
				// print the end time
				long elapsedTime = endTime - startTime;
				// calculate the time difference on each loop

				System.out.println("Loop " + (i + 1) + " took " + elapsedTime + " milliseconds");
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
		long startTime = System.currentTimeMillis();
		long maxWaitTime = Duration.ofSeconds(15).toMillis();
		// 15 sec max wait because my laptop is being slow
		// changed to milli secs

		long endTime = startTime + maxWaitTime; // Calculate the end time

		while (System.currentTimeMillis() < endTime) {
			String cartTotal = driver.findElement(header_cartNumber).getText();
			int actualCartTotal = Integer.parseInt(cartTotal);
			//parseInt just makes string to int
			//cartTotal is the element then i .getText
			//so if the cart total is 1 then it will be "1" <== string
			//parseInt makes "1" to 1 <== int
			//then i can compare int to int

			if (actualCartTotal == expectedCartTotal) {
				return;
			}

			waitForShortInterval();
		}

		handleTimeout();
		// handle exception when if the test goes over 15 secs

	}

	public static void waitForShortInterval() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}

	}

	public static void handleTimeout() {
		System.out.println("Timeout: Cart total did not update or took too long :(");
	}
}
