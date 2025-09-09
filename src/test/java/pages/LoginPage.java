package pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public LoginPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

    public void clickLogin() {
        try {
            driver.findElement(Locators.loginButton).click();
            extTest.log(Status.PASS, "Clicked on Login button");
        } 
        catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Login button: " + e.getMessage());
            throw e;
        }
    }

    public void enterMobileNumber(String mobile) {
        try {
            driver.findElement(Locators.inputNumber).sendKeys(mobile);
            extTest.log(Status.PASS, "Entered mobile number: " + mobile);
        }
        catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to enter mobile number: " + e.getMessage());
            throw e;
        }
    }

    public void clickContinue() {
        try {
            driver.findElement(Locators.continueButton).click();
            extTest.log(Status.PASS, "Clicked Continue button");
        } 
        catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Continue button: " + e.getMessage());
            throw e;
        }
    }

    public void enterOtp(String otp) {
        try {
            WebElement otpField = driver.findElement(Locators.otpInputs);
            otpField.sendKeys(otp);
            extTest.log(Status.PASS, "Entered OTP: " + otp);
        } 
        catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to enter OTP: " + e.getMessage());
            throw e;
        }
    }

    public void enterOtpManually(WebDriver driver) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter OTP from SMS: ");
            String otp = sc.nextLine();

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement otpBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otpInputs));
            otpBox.sendKeys(otp);

            extTest.log(Status.PASS, "Manually entered OTP: " + otp);
        }
        catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to enter OTP manually: " + e.getMessage());
            throw e;
        }
    }

    public void clickResendOtp() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(35));
            wait.until(ExpectedConditions.elementToBeClickable(Locators.resendOtpButton)).click();
            extTest.log(Status.PASS, "Clicked Resend OTP button");
        } 
        catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Resend OTP button: " + e.getMessage());
            throw e;
        }
    }

    public boolean getNumErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter valid phone number')]")));
            extTest.log(Status.PASS, "Displayed error: Invalid phone number");
            return true;
        } 
        catch (TimeoutException te) {
            extTest.log(Status.FAIL, "Error message for invalid phone number not displayed");
            return false;
        }
    }

    public boolean getOtpErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter valid OTP')]")));
            extTest.log(Status.PASS, "Displayed error: Invalid OTP");
            return true;
        } 
        catch (TimeoutException te) {
            extTest.log(Status.FAIL, "Error message for invalid OTP not displayed");
            return false;
        }
    }

    public boolean loginsuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-icon")));
            extTest.log(Status.PASS, "Login successful - Profile icon is visible");
            return true;
        } 
        catch (TimeoutException te) {
            extTest.log(Status.FAIL, "Login failed - Profile icon not found");
            return false;
        }
    }
}