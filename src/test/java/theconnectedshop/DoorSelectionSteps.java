package theconnectedshop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DoorSelectionSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private ScrollHelper scrollHelper;

    @Given("The user is on the page {string}")
    public void the_user_is_on_the_page(String pageUrl) {
        System.out.println("User is on the page: " + pageUrl);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://theconnectedshop.com/");
        System.out.println("User is on the connected shop home page");
    }

    @And("The user scrolls down the page a bit")
    public void the_user_scrolls_down_the_page_a_bit() {
        int scrollAmount = 500;
        ScrollHelper.scrollDown(driver, scrollAmount);
    }

    @And("The user should click ok to skip popup")
    public void the_user_should_click_ok_to_skip_popup() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.NewsletterPopup__Close")));
            closeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Close button not found immediately. Proceeding...");
        }
        try {
            WebElement okCookieButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopify-pc__banner__btn-accept")));
            okCookieButton.click();
        } catch (TimeoutException e) {
            System.out.println("OK Cookie button not found immediately. Proceeding...");
        }
    }

    @When("The user selects the first smart doors")
    public void the_user_selects_the_first_smart_doors() {
        System.out.println("User selects the first smart doors");
        WebElement firstSmartDoor = driver.findElement(By.xpath("//img[@alt='Smart Door Lock Slim Fingerprint Door Lock with Mobile App slim Smart Door Lock and Fingerprint Smart Lock']"));
        if (firstSmartDoor != null) {
            firstSmartDoor.click();
        } else {
            System.out.println("No smart doors found on the page");
        }
    }

    @Then("The user should see details of the selected smart doors")
    public void the_user_should_see_details_of_the_selected_smart_doors() {
        // Implementing the code to verify that details of the selected smart doors are displayed
        System.out.println("User sees details of the selected smart doors");
        WebElement productNameElement = driver.findElement(By.xpath("//img[@alt='Smart Door Lock Slim Fingerprint Door Lock with Mobile App slim Smart Door Lock and Fingerprint Smart Lock']"));
        System.out.println("Product Name: " + productNameElement.getText());
    }

    @Given("The user is on the product page {string}")
    public void the_user_is_on_the_product_page(String pageUrl) {
        System.out.println("User is on the page: " + pageUrl);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://theconnectedshop.com/products/smart-door-lock-slim");
        System.out.println("User is on the product page");
    }

    @And("The user scrolls down the page to the review section")
    public void the_user_scrolls_down_the_page_to_the_review_section() throws InterruptedException {
        By reviewButtonLocator = By.className("jdgm-rev-widg__header");
        WebElement reviewButton = driver.findElement(reviewButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", reviewButton);
        wait.until(ExpectedConditions.elementToBeClickable(reviewButtonLocator));
    }

    @Then("The user checks whether the reviews section is visible")
    public void the_user_checks_whether_the_reviews_section_is_visible() {
        By reviewButtonLocator = By.className("jdgm-rev-widg__header");
        WebElement reviewButton = driver.findElement(reviewButtonLocator);
        ScrollHelper scrollHelper = new ScrollHelper(driver);
        scrollHelper.scrollIntoView(reviewButton);
    }

    @And("The user click on the write a review button")
    public void the_user_click_on_the_write_a_review_button() {
        ScrollHelper scrollHelper = new ScrollHelper(driver);
        scrollHelper.writeReviewClick();
    }

    @Then("The user clicks to cancel the review")
    public void the_user_clicks_to_cancel_the_review() {
        try {
            WebElement cancelReview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='jdgm-write-rev-link close-form-btn']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(cancelReview).perform();
            cancelReview.click();
            System.out.println("Clicked on Cancel Review");
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for Cancel Review button to be clickable");
            e.printStackTrace();
        }
    }
}