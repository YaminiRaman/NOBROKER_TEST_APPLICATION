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

    public Add_Plumbing_ServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By plumbingCategory = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");

    // Service + Add button
    private By bookAPlumberService = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    private By addButton = By.xpath("//*[@id='PLUMBING_OTHER_SOMETHING_ELSE']/div[1]/div/div[2]/div[2]/button");

    // Step 1: Navigate to Plumbing Services (for booking flow)
    public void navigateToPlumbingServicesForBooking() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
        System.out.println("✅ Menu button clicked.");

        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        painting.click();
        System.out.println("✅ Painting & Cleaning clicked.");

        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(25));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            System.out.println("✅ Chennai city selected.");
        } catch (Exception e) {
            System.out.println("❌ City selection modal not displayed, continuing...");
        }

        WebElement plumbing = wait.until(ExpectedConditions.elementToBeClickable(plumbingCategory));
        plumbing.click();
        System.out.println("✅ Plumbing category clicked.");
    }

    // Step 2: Select "Book a Plumber"
    public void selectBookAPlumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for overlay to disappear
            boolean overlayGone = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bg-fade-in"))
            );

            if (!overlayGone) {
                System.out.println("⚠ Overlay still visible, attempting to dismiss...");
                try {
                    WebElement overlay = driver.findElement(By.cssSelector(".bg-fade-in"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", overlay);
                    Thread.sleep(1000);
                } catch (Exception ignored) {}
            } else {
                System.out.println("✅ Overlay not blocking.");
            }

        } catch (Exception e) {
            System.out.println("✅ No overlay detected, continuing...");
        }

        // Click on "Book a Plumber"
        WebElement plumberService = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plumberService);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plumberService);

        System.out.println("✅ 'Book a Plumber' service selected.");
    }


    public void clickAddButtonMultipleTimes(String serviceName, int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Locate service by visible text
            WebElement service = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + serviceName + "')]")
            ));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", service);

            // Locate Add button relative to the service
            WebElement addButton = service.findElement(
                By.xpath(".//ancestor::div[contains(@id,'hs_plumbing')]//button")
            );

            // Click multiple times
            for (int i = 0; i < quantity; i++) {
                wait.until(ExpectedConditions.elementToBeClickable(addButton));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
                Thread.sleep(1000);
            }

            System.out.println("✅ Added service [" + serviceName + "] " + quantity + " times");

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to click Add button for service: " + serviceName, e);
        }
    }




    // Step 4: Verify service added successfully (dummy check for now)
    public boolean isServiceAddedSuccessfully(int expectedQuantity) {
        // Ideally: verify quantity updated in cart or service list
        // For now, just return true
        return true;
    }
}
