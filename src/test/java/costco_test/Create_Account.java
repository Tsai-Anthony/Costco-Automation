package costco_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.Keywords;

public class Create_Account {
	
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features");
		options.addArguments("--disable-blink-features=AutomationControlled");

		
		String email = "abc@def.com";
		String password1 = "123Abc324";
		String password2 = "123Abc";
		String message1 = "Invalid email address";
		String message2 = "Password has to be 8-16 charactors";
		String message4 = "passwords do not match!";
		String message3 = "Password needs one of special charactors:'!@#$&'";
		
		try {
			driver.get("https://www.costco.com/");
			WebElement element1 = driver.findElement(By.xpath("//*/a[@href='https://www.costco.com/LogonForm']"
					+ "[@automation-id='mobileMyAccountLink']"));
			javascriptClick(element1);
			
			
			WebElement element2 = driver.findElement(By.xpath("//p/a[@id='createAccount']"));
			javascriptClick(element2);
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
			if(!email.contains("@")|| !email.contains(".")) {
				throw new Exception(message1);
			}
			driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys(password1);
			if(password1.length()<8 || password1.length()>16) {
				throw new Exception(message2);
			}
			else if(!password1.contains("{!,@,#,$,&}")) {
				throw new Exception(message3);
			}
			
			driver.findElement(By.xpath("//*/input[@id='reenterPassword']")).sendKeys(password2);
			if(!password2.equals(password1)) {
				throw new Exception(message4);
			}
			
			Keywords.wait(2);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.println("\nTest Failed");
			e.printStackTrace();
		}

	}

	

	static void javascriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

}
