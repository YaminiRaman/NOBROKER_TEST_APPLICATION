package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Showmore_Plumbing_Page {

    WebDriver driver;
    WebDriverWait wait;

    // 🔹 Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By epcBtn1 = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    private By epcBtn2 = By.xpath("//*[@id='hs_plumbing']/div[1]/div[2]");
    private By plumbingBtn = By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]");
    private By bookPlumberBtn = By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div");
    private By showMoreBtn = By.xpath("//*[@id='PLUMBING_OTHER_SOMETHING_ELSE']/div[3]/div/div");

    // 🔹 Constructor
    public Showmore_Plumbing_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // 🔹 Actions
    public void clickMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();
        System.out.println("✅ Clicked Menu Button");
    }

    public void clickPaintingCleaning() {
        wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning)).click();
        System.out.println("✅ Clicked Painting & Cleaning");
    }

    public void selectCity() {
        wait.until(ExpectedConditions.elementToBeClickable(chennaiImage)).click();
        System.out.println("✅ Selected Chennai City");
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

    public void clickBookPlumber() {
        WebElement plumberBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(bookPlumberBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plumberBtn);
        plumberBtn.click();
        System.out.println("✅ Book a Plumber clicked after scrolling.");
    }


    public void clickShowMore() {
        WebElement showMore = wait.until(ExpectedConditions.visibilityOfElementLocated(showMoreBtn));
        
        // Scroll into view using Actions
        new Actions(driver).moveToElement(showMore).perform();
        
        // Wait until clickable, then click
        wait.until(ExpectedConditions.elementToBeClickable(showMore)).click();
        System.out.println("✅ Show More clicked.");
    }

    public boolean isServiceDetailsVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(showMoreBtn));
            boolean visible = element.isDisplayed();
            System.out.println("🔎 Service details visible? " + visible);
            return visible;
        } catch (Exception e) {
            System.out.println("❌ Service details not visible.");
            return false;
        }
    }
}
