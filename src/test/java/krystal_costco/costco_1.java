package krystal_costco;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Keywords;

public class costco_1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		String search = "disney";
		String xpath = "//button[@automation-id='addToCartButton_0']";

		WebElement howMany = driver.findElement(By.xpath(xpath));
		int count = 0;
		
		try {
			driver.navigate().to("https://www.costco.com/");
			driver.findElement(By.xpath("//input[@aria-describedby='search-field-description']")).sendKeys(search);

			howMany.click();
			Keywords.wait(1);
			count++;

		

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
