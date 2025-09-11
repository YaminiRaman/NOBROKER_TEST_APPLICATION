package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	//login page locator
	
	public static By loginButton=By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div");
	public static By inputNumber=By.id("signUp-phoneNumber");
	public static By continueButton=By.id("signUpSubmit");
	public static By otpInputs = By.xpath("//input[@aria-label='Please enter verification code. Digit 1']");
	public static By resendOtpButton=By.xpath("//div[contains(@class,'nb__G_7wy') and text()='Resend OTP']");
	
			
	public static By searchCity=By.id("//*[@id=\"app\"]/div/div/div[2]/div[4]/div[1]");
	public static By searchLocality=By.id("/html/body");
	public static By searchButton=By.xpath("//button[@type='button' and contains(@class,'prop-search-button')]");
	public static By historySection = By.cssSelector("div.QuickBook_autoSearchPopover__g1zGj"); 
	public static By historyItems   = By.cssSelector("div.QuickBook_autoSearchPopover__g1zGj div");
	
	public static final By touchProfile= By.xpath("//*[@id=\"profile-icon\"]/div");
    public static final By signOutBtn= By.xpath("//*[@id=\"profile-menu-dropdown\"]/div[6]");
}