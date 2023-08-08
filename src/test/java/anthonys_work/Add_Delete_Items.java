package anthonys_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import utilities.Keywords;

public class Practicing_This_Branch {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features");
		options.addArguments("--disable-blink-features=AutomationControlled");
		String MacBookProM2_16inch = "//*[@id='addbutton-6']";
		try {
			driver.get("https://www.costco.com/");
			driver.findElement(By.xpath("//*[@id='navigation-dropdown']"));
			Actions action = new Actions(driver);
			WebElement elementToHover = driver.findElement(By.xpath("//*[@id='navigation-dropdown']"));
			action.moveToElement(elementToHover).perform();
			Keywords.wait(2);
			Actions action1 = new Actions(driver);
			WebElement subMenu = driver.findElement(By.xpath("//*[@id='5']/a"));
			action1.moveToElement(subMenu).perform();
			driver.findElement(By.linkText("Computers")).click();
			driver.findElement(By.xpath("//*[@id='navpills-sizing']/a[1]")).click();
			driver.findElement(By.name("MacBook")).click();
			// driver.findElement(By.xpath("//*[@id='addbutton-0']")).click();
			driver.findElement(By.xpath(MacBookProM2_16inch)).click();
			WebElement multiClick = driver.findElement(By.xpath("//*[@id='plusQty']"));
			int clickCount = 2;
			for (int i = 1; i < clickCount; i++) {
				multiClick.click();
				Keywords.wait(2);
			}
			if (clickCount != 2) {
				String message = "Exceeded maximum limit per cart." + "\n" + "Item may also be out of stock";
				throw new Exception(message);
			}
			Keywords.wait(2);
			driver.findElement(By.xpath("//*[@id='add-to-cart-btn']")).click();
			Keywords.wait(10);
			driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();

			Keywords.wait(4);

			driver.findElement(By.xpath("//*[@automation-id='removeItemLink_1']")).click();
			String removeButton = driver.findElement(By.xpath("//*[@automation-id='removeItemLink_1']")).getText();
			if (!removeButton.equals("remove item")) {
				throw new Exception("Remove button not found, empty cart.");
			}
			System.out.println("Test passed");
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Something went wrong!!! " + e.getMessage());
		} finally {
			driver.quit();
			// will add more conditional statements after i sleep :)
		}

	}
}
