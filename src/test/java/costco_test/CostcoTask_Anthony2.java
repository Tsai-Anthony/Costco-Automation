package costco_test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CostcoTask_Anthony2 extends BaseTest {
	static By nurzatXPath = By.xpath("//*[@id='adb-hero-carousel']//a[@tabindex='0']//img");
	static By myXPath = By.xpath("//*[@id=\"slick-slide13\"]/a/picture/img");

	public static void main(String[] args) {
		validateBanner();
	}

	public static void validateBanner() {
		try {
			setUpTest("https://www.costco.com/");

			customWait(ExpectedConditions.visibilityOfElementLocated(nurzatXPath));

			if (checkIfElementExists(driver, nurzatXPath)) {
				System.out.println("Banner Test Found!");
			} else {
				WebElement firstImage = driver.findElement(nurzatXPath);
				WebElement secondImage = driver.findElement(myXPath);
				Assertions.assertTrue(firstImage != secondImage, "Images are not the same");
				System.out.println("Banner Test FAILED");
			}

		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println("Reason: " + e.getMessage());
			e.printStackTrace();
		} finally {
			endTest();
		}
	}

	public static WebElement customWait(ExpectedCondition<WebElement> expectedCondition) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		return wait.until(expectedCondition);
	}

	static boolean checkIfElementExists(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
