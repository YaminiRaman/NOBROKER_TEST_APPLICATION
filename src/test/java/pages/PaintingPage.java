package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaintingPage {
    WebDriver driver;
    WebDriverWait wait;

    By menuBtn = By.xpath("//*[@id=\"main-menu\"]/div[1]");
    By paintingCleaning = By.xpath("//*[@id=\"main-menu\"]/div[2]/a[3]");
    By chennaiImage = By.xpath("//*[@id=\"modalContent\"]/div[2]/div/div[3]/img");
    By painting = By.xpath("//*[@id=\"hs_painting\"]/div[1]/div[1]/div");
    By waterproofing = By.xpath("//*[@id=\"WATER_PROOFING\"]/div[1]/div[1]/div");

    public PaintingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void loginForPainting() {
        // 🔹 Call your common login method here
        // Example:
        // LoginPage login = new LoginPage(driver);
        // login.performLogin("8015888674", "123456");
    }

    public void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();
    }

    public void selectPaintingCleaning() {
        wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning)).click();
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

    public void selectPainting() {
        wait.until(ExpectedConditions.elementToBeClickable(painting)).click();
    }

    public void selectWaterproofing() {
        wait.until(ExpectedConditions.elementToBeClickable(waterproofing)).click();
    }
}
