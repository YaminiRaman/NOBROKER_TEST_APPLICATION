package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Plumbing_Service_Page {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Plumbing_Service_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    // ---------------- LOCATORS ----------------
    By menuButton = By.xpath("//*[@id='main-menu']/div[1]");
    By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    By epcButton = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    By plumbingButton = By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]");
    By plumbingCategory = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    By bookPlumberButton = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    By showMoreButton = By.xpath("//*[@id=\"PLUMBING_OTHER_SOMETHING_ELSE\"]/div[3]/div/div");

  
    By overlay = By.cssSelector(".bg-fade-in");

    // ---------------- ACTIONS ----------------
    public void clickMenuButton() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        js.executeScript("arguments[0].click();", menu);
        System.out.println("✅ Menu button clicked.");
    }

    public void clickPaintingCleaning() {
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

    public void clickEPCButton() {
        WebElement epc = wait.until(ExpectedConditions.elementToBeClickable(epcButton));
        js.executeScript("arguments[0].click();", epc);
        System.out.println("✅ EPC button clicked.");
    }

    public void clickPlumbingButton() {
        WebElement plumbing = wait.until(ExpectedConditions.elementToBeClickable(plumbingButton));
        js.executeScript("arguments[0].click();", plumbing);
        System.out.println("✅ Plumbing button clicked.");
    }

    public void clickPlumbingCategory() {
        // Wait for overlay to disappear if exists
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(plumbingCategory));
        js.executeScript("arguments[0].click();", category);
        System.out.println("✅ Plumbing category clicked.");
    }

    public void clickBookPlumber() {
        WebElement bookBtn = wait.until(ExpectedConditions.elementToBeClickable(bookPlumberButton));
        js.executeScript("arguments[0].scrollIntoView(true);", bookBtn);
        js.executeScript("arguments[0].click();", bookBtn);
        System.out.println("✅ Book a Plumber clicked.");
    }
   
    public void clickShowMore() {
        WebElement showMore = wait.until(ExpectedConditions.elementToBeClickable(showMoreButton));
        js.executeScript("arguments[0].scrollIntoView(true);", showMore);
        js.executeScript("arguments[0].click();", showMore);
        System.out.println("✅ Show More clicked.");
    }




   
}
