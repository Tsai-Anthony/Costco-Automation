package costco_test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
                long startTime = System.currentTimeMillis(); // Record the start time
                addToCarts.get(i).click();
                waitForCartTotalUpdate(i + 1);
                long endTime = System.currentTimeMillis(); // Record the end time
                long elapsedTime = endTime - startTime; // Calculate the time taken

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
        long maxWaitTime = Duration.ofSeconds(15).toMillis(); // 15 seconds in milliseconds
        long endTime = startTime + maxWaitTime; // Calculate the end time

        while (System.currentTimeMillis() < endTime) {
            String cartTotal = driver.findElement(header_cartNumber).getText();
            int actualCartTotal = Integer.parseInt(cartTotal);

            if (actualCartTotal == expectedCartTotal) {
                return; // Exit the loop when condition is met
            }

            waitForShortInterval();
        }

        handleTimeout(); // Handle the case when the expected condition is not met within the timeout
    }

    public static void waitForShortInterval() {
        try {
            Thread.sleep(500); // Wait for a short interval (500 milliseconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void handleTimeout() {
        System.out.println("Timeout: Cart total did not update as expected.");
    }
}
