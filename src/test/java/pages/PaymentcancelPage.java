package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentcancelPage {

    WebDriver driver;
    WebDriverWait wait;

    // ✅ Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]/img");            // Menu button
    private By tenantPlansLink = By.xpath("//*[@id='main-menu']/div[2]/a[7]");   // Tenant Plans link
    private By freedomPlanSubscribeBtn = By.xpath("//*[@id='payPlanType']");     // Subscribe button

    private By backButton = By.xpath("/html/body/div[1]/div[1]/header/div[1]/div[1]/div[2]"); // Back button
    private By cancelPaymentYesBtn = By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/button[1]"); // Cancel Payment Yes
   

    public PaymentcancelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Click on Menu
    public void clickMenu() {
        WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.visibilityOf(menu));
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
    }

    // Click on Tenant Plans
    public void clickTenantPlans() {
        WebElement plans = wait.until(ExpectedConditions.presenceOfElementLocated(tenantPlansLink));
        wait.until(ExpectedConditions.visibilityOf(plans));
        wait.until(ExpectedConditions.elementToBeClickable(plans)).click();
    }

    // Click Freedom Plan Subscribe button
    public void clickFreedomPlanSubscribe() {
        WebElement subscribeBtn = wait.until(ExpectedConditions.presenceOfElementLocated(freedomPlanSubscribeBtn));
        wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
        wait.until(ExpectedConditions.elementToBeClickable(subscribeBtn)).click();
    }

    // Click Back button on payment page
    public void clickBackButton() {
        WebElement back = wait.until(ExpectedConditions.elementToBeClickable(backButton));
        back.click();
    }

    // Confirm cancel payment
    public void confirmCancelPayment() {
        WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(cancelPaymentYesBtn));
        yesBtn.click();
    }

    // Check if notification is visible
    
}
