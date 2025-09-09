package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Carpentry_Service_SelectPage {
    WebDriver driver;
    WebDriverWait wait;

    public Carpentry_Service_SelectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By epcBtn1 = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    private By epcBtn2 = By.xpath("//*[@id='hs_plumbing']/div[1]/div[2]");
    // ✅ More stable locator for carpentry (by visible text)
    private By carpentryCategory = By.xpath("//div[contains(text(),'Carpentry')]");
    private By firstCarpentryService = By.xpath("//*[@id='hs_carpentry']/div[1]/div[1]/div");
    

    // Actions
    public void clickMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();
        System.out.println("✅ Menu button clicked.");
    }

    public void clickPaintingCleaning() {
        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        painting.click();
        System.out.println("✅ Painting & Cleaning clicked.");
    }

    public void selectCity() {
        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(25));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            System.out.println("✅ Chennai city selected.");
        } catch (Exception e) {
            System.out.println("❌ City selection modal not displayed, continuing...");
        }
    }
    public void clickEPCButton() {
        // try EPC button 1, if not clickable then EPC button 2
        try {
            wait.until(ExpectedConditions.elementToBeClickable(epcBtn1)).click();
            System.out.println("✅ Clicked EPC Button 1");
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(epcBtn2)).click();
            System.out.println("✅ Clicked EPC Button 2 (fallback)");
        }
    }

    public void clickCarpentryCategory() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Scroll until element is visible
            WebElement carpentryCategory = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(text(),'Carpentry')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carpentryCategory);

            // Now wait for it to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(carpentryCategory)).click();

            System.out.println("✅ Carpentry category clicked.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Carpentry category: " + e.getMessage());
            throw e;
        }
    }

    public void clickFirstCarpentryService() {
        try {
            WebElement service = wait.until(ExpectedConditions.elementToBeClickable(firstCarpentryService));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", service);
            service.click();
            System.out.println("✅ First carpentry service clicked.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click first carpentry service: " + e.getMessage());
            throw e;
        }
    }

    
}
