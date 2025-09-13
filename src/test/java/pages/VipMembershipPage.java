package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VipMembershipPage {
    WebDriver driver;
    WebDriverWait wait;

    // ✅ Locators
   public By menuBtn = By.xpath("//*[@id=\"main-menu\"]/div[1]");
   public By paintingCleaning = By.xpath("//*[@id=\"main-menu\"]/div[2]/a[3]");
   public By chennaiImage = By.xpath("//*[@id=\"modalContent\"]/div[2]/div/div[3]/img");
   public By vipPlans = By.xpath("//*[@id=\"0\"]/div/div/div/button");
  

    public VipMembershipPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    

    public void clickMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();
        System.out.println("✅ Clicked Menu");
    }

    public void clickPaintingAndCleaning() {
        wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning)).click();
        System.out.println("✅ Clicked Painting & Cleaning");
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

    public void viewVipPlans() {
        WebElement planBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vipPlans)
        );
        planBtn.click();
        System.out.println("✅ Viewed VIP Plans");
    }

    
    
}
