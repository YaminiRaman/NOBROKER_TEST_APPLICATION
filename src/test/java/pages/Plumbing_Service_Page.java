package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Plumbing_Service_Page {

    WebDriver driver;
    WebDriverWait wait;

    public Plumbing_Service_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By epcBtn1 = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    private By epcBtn2 = By.xpath("//*[@id='hs_plumbing']/div[1]/div[2]");
    private By plumbingBtn = By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]");
    private By plumbingCategory = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
  

    // Step 1: Click Menu
    public void clickMenuButton() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
        System.out.println("✅ Menu button clicked.");
    }

    // Step 2: Click Painting & Cleaning
    public void clickPaintingCleaning() {
        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        painting.click();
        System.out.println("✅ Painting & Cleaning clicked.");
    }

    // Step 3: Select City from Modal
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

    public void clickPlumbingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plumbingBtn)).click();
        System.out.println("✅ Clicked Plumbing Button");
    }

    // Step 4: Click Plumbing Category
    public void clickPlumbingCategory() {
        WebElement plumbing = wait.until(ExpectedConditions.elementToBeClickable(plumbingCategory));
        plumbing.click();
        System.out.println("✅ Plumbing category clicked.");
    }

    // Step 5: Verify Plumbing Services are visible
   
}