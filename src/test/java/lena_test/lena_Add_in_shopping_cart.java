package lena_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Keywords;

public class lena_Add_in_shopping_cart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		int time = 3;

		try {
			driver.get("https://www.costco.com/");
			// TV
			driver.findElement(By.xpath("//div[@class='col-xs-6 eco-slide'][1]")).click();
			// Add
			driver.findElement(By.xpath("//button[@id='addbutton-3']")).click();

			click(driver, time);
			Keywords.wait(3);

			// validation
			String actuallNumber = driver.findElement(By.xpath("//input[@id='value-3']")).getAttribute("value");
			int actualNum = Integer.parseInt(actuallNumber);

			if (actualNum != time) {

				System.out.println("wrong item amount" + "actual items: " + actualNum + "Expected items: " + time);
			}

			System.out.println("test passed");
		} catch (Exception e) {
			System.out.println("test failed");
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}

	public static void click(WebDriver driver, int time) {
		for (int i = 0; i < time - 1; i++) {
			driver.findElement(By.xpath("//button[@id='add-3']")).click();

		}

	}

}
