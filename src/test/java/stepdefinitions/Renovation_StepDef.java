package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.RenovationPage;
 // assuming Hooks.driver and Hooks.extTest exist

public class Renovation_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    RenovationPage renovationPage;

    @Given("the user logs in with a valid mobile number and OTP for renovation")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();
        loginPage.enterOtpManually(driver);

        // wait for OTP verification
        loginPage.clickContinue();

        boolean loggedIn = loginPage.loginsuccessful();
        Assert.assertTrue(loggedIn, "❌ Login failed!");
        System.out.println("✅ User logged in successfully.");
    }

    @When("the user navigates through Home Renovation services")
    public void the_user_navigates_through_home_renovation_services() {
        renovationPage = new RenovationPage(driver);

        renovationPage.clickMenuButton();
        renovationPage.clickPaintingAndCleaning();
        renovationPage.selectCity(); // optional if city selection pops up
        renovationPage.clickInteriorAndRenovation();
        renovationPage.clickHomeRenovation();
        
      
       
        
    }
    
    

  
}
