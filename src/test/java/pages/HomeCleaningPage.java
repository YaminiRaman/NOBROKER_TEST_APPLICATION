package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeCleaningPage {
    WebDriver driver;

    // Locators
    By menuBtn = By.xpath("//*[@id=\"main-menu\"]/div[1]");
    By paintingCleaning = By.xpath("//*[@id=\"main-menu\"]/div[2]/a[3]");
    By chennaiImage = By.xpath("//*[@id=\"modalContent\"]/div[2]/div/div[3]/img");
    By homeCleaning = By.xpath("//*[@id=\"hs_cleaning\"]/div[1]/div[1]/div");
    By fullHouseCleaning = By.xpath("//*[@id=\"app\"]/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]");
    By furnishedVilla = By.xpath("//*[@id='hs_bathroom_cleaning']/div[1]/div[1]/div");
   

    // Constructor
    public HomeCleaningPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickMenu() {
        driver.findElement(menuBtn).click();
    }

    public void clickPaintingCleaning() {
        driver.findElement(paintingCleaning).click();
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

    public void clickHomeCleaning() {
        driver.findElement(homeCleaning).click();
    }

    public void clickFullHouseCleaning() {
        driver.findElement(fullHouseCleaning).click();
    }

    public void clickFurnishedVilla() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement villa = wait.until(ExpectedConditions.presenceOfElementLocated(furnishedVilla));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", villa);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", villa);

        System.out.println("✅ Furnished Villa clicked with JS.");
    }

}
