package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RenovationPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    // ---------------- LOCATORS ----------------
    By menuButton = By.xpath("//*[@id='main-menu']/div[1]");
    By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    By interiorAndRenovation = By.xpath("//*[@id='hs_home_renovation']/div[1]/div[1]/div");
    By homeRenovation = By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[2]/div[2]");


  
    By overlay = By.cssSelector(".bg-fade-in");

    // ---------------- CONSTRUCTOR ----------------
    public RenovationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    // ---------------- ACTIONS ----------------
    public void clickMenuButton() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        js.executeScript("arguments[0].click();", menu);
        System.out.println("✅ Menu button clicked.");
    }

    public void clickPaintingAndCleaning() {
        WebElement pc = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        js.executeScript("arguments[0].click();", pc);
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

    public void clickInteriorAndRenovation() {
        WebElement interior = wait.until(ExpectedConditions.elementToBeClickable(interiorAndRenovation));
        js.executeScript("arguments[0].click();", interior);
        System.out.println("✅ Interior & Renovation clicked.");
    }

    public void clickHomeRenovation() {
        WebElement home = wait.until(ExpectedConditions.elementToBeClickable(homeRenovation));
        js.executeScript("arguments[0].scrollIntoView(true);", home);
        js.executeScript("arguments[0].click();", home);
        System.out.println("✅ Home Renovation clicked.");
    }
    



   
}
