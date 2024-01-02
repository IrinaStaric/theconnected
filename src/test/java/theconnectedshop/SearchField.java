package theconnectedshop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchField {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to the Connected Shop website
            driver.get("https://theconnectedshop.com/");

            WebElement searchField = driver.findElement(By.id("searchFieldId"));
            searchField.click();

            searchField.sendKeys("Invalid Text");

            searchField.sendKeys(Keys.ENTER);

            searchField.clear();

            searchField.sendKeys("smart doors");

            searchField.sendKeys(Keys.ENTER);

            WebElement firstDoor = driver.findElement((By.xpath("//img[@alt='Smart Door Lock Slim Fingerprint Door Lock with Mobile App slim Smart Door Lock and Fingerprint Smart Lock']")));
            firstDoor.click();

            if (driver.getCurrentUrl().contains("smart-door-details")) {
                System.out.println("Successfully clicked on the first smart door.");
            } else {
                System.out.println("Failed to click on the first smart door.");
            }

        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}
