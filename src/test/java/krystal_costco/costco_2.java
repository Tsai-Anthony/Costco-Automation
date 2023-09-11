package krystal_costco;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class costco_2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String search = "disney";

		try {

			driver.navigate().to("https://www.costco.com/");
			driver.findElement(By.xpath("//input[@aria-describedby='search-field-description']")).sendKeys(search);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@automation-id='productDescriptionLink_0']")).click();
			driver.findElement(By.xpath("//input[@name='add-to-cart']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@automation-id='viewCartButton']")).click();
			Thread.sleep(2000);
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}finally {
			driver.close();
			driver.quit();
		}
	}
}