package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Blog_Page {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By menuButton = By.xpath("//*[@id='main-menu']/div[1]"); // Menu button to expand
    private By blogsButton = By.xpath("//*[@id='main-menu']/div[2]/a[13]"); // Blog button
    private By listButton = By.xpath("//*[@id='hamburger']"); // List button (top-left corner)
    private By interiorsDropdown = By.xpath("//*[@id='dropdownContent']/div[2]/div[5]/div[1]/div"); // Interiors dropdown
    private By renovationOption = By.xpath("//*[@id='dropdownContent']/div[2]/div[5]/div[2]/a[1]"); // Renovation option

    // Constructor
    public Blog_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Navigate to Renovation blogs
    public void navigateToRenovationBlogs() {

        // Close overlay popup if it exists
        try {
            WebElement closeBtn = driver.findElement(By.cssSelector(".overlay .close-btn"));
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
                System.out.println("✅ Overlay closed");
            }
        } catch (NoSuchElementException e) {
            // No overlay, continue
        }

        // Click menu button
        WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuBtn.click();
        System.out.println("✅ Menu button clicked");

        // Click blog button
        WebElement blogBtn = wait.until(ExpectedConditions.elementToBeClickable(blogsButton));
        blogBtn.click();
        System.out.println("✅ Blog button clicked");

        // Click list button
        WebElement listBtn = wait.until(ExpectedConditions.elementToBeClickable(listButton));
        listBtn.click();
        System.out.println("✅ List button clicked");

        // Click Interiors dropdown
        WebElement interiors = wait.until(ExpectedConditions.elementToBeClickable(interiorsDropdown));
        interiors.click();
        System.out.println("✅ Interiors dropdown clicked");

        // Click Renovation option
        WebElement renovation = wait.until(ExpectedConditions.elementToBeClickable(renovationOption));
        renovation.click();
        System.out.println("✅ Renovation option clicked");
    }
    
}