package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Plumbing_ServicePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Add_Plumbing_ServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By plumbingCategory = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");

    /**
     * Navigate to the Plumbing Services category.
     * This method clicks menu -> Painting & Cleaning -> selects city if modal appears -> Plumbing.
     */
    public void navigateToPlumbingServicesForBooking() {
        // Click main menu
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
        System.out.println("✅ Menu button clicked.");

        // Click Painting & Cleaning
        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        painting.click();
        System.out.println("✅ Painting & Cleaning clicked.");

        // Handle city selection modal (if appears)
        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            System.out.println("✅ Chennai city selected.");
        } catch (Exception e) {
            System.out.println("ℹ City selection modal not displayed, continuing...");
        }

        // Click Plumbing category
        WebElement plumbing = wait.until(ExpectedConditions.elementToBeClickable(plumbingCategory));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plumbing);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plumbing);
        System.out.println("✅ Plumbing category clicked.");
    }

    /**
     * Clicks the "Book a Plumber" service.
     * No Add button interaction.
     */
    public void selectBookAPlumber() {
        try {
            WebElement plumberService = wait.until(ExpectedConditions.elementToBeClickable(plumbingCategory));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plumberService);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plumberService);
            System.out.println("✅ 'Book a Plumber' clicked successfully.");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to click 'Book a Plumber'", e);
        }
    }
}
