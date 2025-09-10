package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VipMembershipPage {
    WebDriver driver;
    WebDriverWait wait;

    // ✅ Locators
    By menuBtn = By.xpath("//*[@id=\"main-menu\"]/div[1]");
    By paintingCleaning = By.xpath("//*[@id=\"main-menu\"]/div[2]/a[3]");
    By chennaiImage = By.xpath("//*[@id=\"modalContent\"]/div[2]/div/div[3]/img");
    By vipPlans = By.xpath("//*[@id=\"0\"]/div/div/div/button");
    By giftVoucher = By.xpath("/html/body/div[1]/div/header/nav/div[1]/ul/li[4]");
    By exploreOffer = By.xpath("//*[@id=\"web-gv\"]/div[5]/button");

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
        wait.until(ExpectedConditions.elementToBeClickable(vipPlans)).click();
        System.out.println("✅ Viewed VIP Plans");
    }

    public void clickGiftVoucher() {
        WebElement giftBtn = wait.until(ExpectedConditions.presenceOfElementLocated(giftVoucher));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", giftBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", giftBtn);
        System.out.println("✅ Clicked Gift Voucher via JS");
    }
    public void clickExploreOffer() {
        WebElement exploreBtn = wait.until(ExpectedConditions.presenceOfElementLocated(exploreOffer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exploreBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exploreBtn);
        System.out.println("✅ Clicked Explore Offer via JS");
    }
}
