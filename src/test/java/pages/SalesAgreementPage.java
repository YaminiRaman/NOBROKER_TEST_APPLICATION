package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SalesAgreementPage {

    WebDriver driver;
  

    // Locators
    private By menuButton = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingAndCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By salesAgreement = By.xpath("//*[@id='hs_sales_agreement']/div[1]/div[1]/div");
    private By exploreAllServices = By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]/div[2]/span/div/div[2]/div[3]/div");
    private By selectPackage = By.xpath("//*[@id=\"REGISTRATION_PACKAGE\"]/div[3]");
    private By continueBtn = By.xpath("//*[@id='app']/div/div[2]/div[2]");
    private By buyNowButton = By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]/div[2]/div/div/div[4]/div/button[2]");
    private By payButton = By.xpath("//*[@id='app']/div/div/div[2]/div[3]/div[5]/div/button/div");
    private By backButton = By.xpath("/html/body/div[1]/div[1]/header/div[1]/div[1]/div[2]");
    private By yesButton = By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/button[1]");
    private By payPageMarker = By.xpath("//*[text()='Payment']");


	private WebDriverWait wait;

	
    	 public SalesAgreementPage(WebDriver driver) {
    	        this.driver = driver;
    	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	    }

    	    // ===== Actions =====
    	    public void clickMenuButton() {
    	        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
    	        menu.click();
    	        System.out.println("✅ Clicked Menu button");
    	    }

    	    public void clickPaintingAndCleaning() {
    	        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingAndCleaning));
    	        painting.click();
    	        System.out.println("✅ Clicked Painting & Cleaning");
    	    }

    	    public void selectCity() {
    	        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
    	        city.click();
    	        System.out.println("✅ Selected City");
    	    }

    	    public void clickSalesAgreement() {
    	        WebElement sales = wait.until(ExpectedConditions.elementToBeClickable(salesAgreement));
    	        sales.click();
    	        System.out.println("✅ Clicked Sales Agreement");
    	    }

    	    public void clickExploreAllServices() {
    	        WebElement explore = wait.until(ExpectedConditions.elementToBeClickable(exploreAllServices));
    	        explore.click();
    	        System.out.println("✅ Clicked Explore All Services");
    	    }

    	    public void selectPackage() {
    	        WebElement pack = wait.until(ExpectedConditions.elementToBeClickable(selectPackage));
    	        pack.click();
    	        System.out.println("✅ Selected Package");
    	        WebElement cont = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
    	        cont.click();
    	        System.out.println("✅ Clicked Continue");
    	    }

    	    public boolean clickBuyNow() {
    	        try {
    	            WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(buyNowButton));
    	            buy.click();
    	            System.out.println("✅ Clicked Buy Now");
    	            wait.until(ExpectedConditions.visibilityOfElementLocated(payPageMarker));
    	            System.out.println("✅ Payment page displayed");
    	            return true;
    	        } catch (Exception e) {
    	            System.err.println("❌ Buy Now failed: " + e.getMessage());
    	            return false;
    	        }
    	    }

    	    public boolean clickPay() {
    	        try {
    	            WebElement pay = wait.until(ExpectedConditions.elementToBeClickable(payButton));
    	            pay.click();
    	            System.out.println("✅ Clicked Pay button");
    	            return true;
    	        } catch (Exception e) {
    	            System.err.println("❌ Pay failed: " + e.getMessage());
    	            return false;
    	        }
    	    }

    	    public boolean clickBack() {
    	        try {
    	            WebElement back = wait.until(ExpectedConditions.elementToBeClickable(backButton));
    	            back.click();
    	            System.out.println("✅ Clicked Back button");
    	            return true;
    	        } catch (Exception e) {
    	            System.err.println("❌ Back failed: " + e.getMessage());
    	            return false;
    	        }
    	    }

    	    public boolean confirmCancel() {
    	        try {
    	            WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
    	            yes.click();
    	            System.out.println("✅ Cancel confirmed");
    	            return true;
    	        } catch (Exception e) {
    	            System.err.println("❌ Cancel failed: " + e.getMessage());
    	            return false;
    	        }
    	    }

    	    public boolean isPaymentPageVisible() {
    	        try {
    	            wait.until(ExpectedConditions.visibilityOfElementLocated(payPageMarker));
    	            return true;
    	        } catch (Exception e) {
    	            return false;
    	        }
    	    }

    	    public void closeBrowser() {
    	        driver.quit();
    	        System.out.println("✅ Browser closed");
    	    }
    	 
    	    }
