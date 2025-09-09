package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Carpentry_ServicePage {
    WebDriver driver;
    WebDriverWait wait;

    public Carpentry_ServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By carpentryCategory = By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[3]/div[2]");
    private By carpentryServicesDisplayed = By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[3]/div[2]");

    // Actions
    public void clickMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();
        System.out.println("✅ Menu button clicked.");
    }

    public void clickCarpentryCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(carpentryCategory)).click();
        System.out.println("✅ Carpentry category clicked.");
    }

    public boolean isCarpentryServicesVisible() {
        try {
            WebElement services = wait.until(ExpectedConditions.visibilityOfElementLocated(carpentryServicesDisplayed));
            return services.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
