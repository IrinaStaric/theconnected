package theconnectedshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//a[@class='jdgm-write-rev-link']")
    private WebElement writeareview;

    public ScrollHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
    public void scrollIntoView(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void writeReviewClick() {
        writeareview.click();
    }
    public static void scrollDown(WebDriver driver, int scrollAmount) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", scrollAmount);
    }
    public static void scrollToElement (WebDriver driver, By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

