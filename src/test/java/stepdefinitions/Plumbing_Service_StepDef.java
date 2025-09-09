package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.Plumbing_Service_Page;

public class Plumbing_Service_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Plumbing_Service_Page servicesPage;

    @Given("the user logs in with a valid mobile number and OTP")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        // Step 1: Enter valid mobile number
        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();

        // Step 2: Enter OTP manually (from console input)
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        // Step 3: Verify login success
        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
    }


    @When("the user navigates to plumbing services")
    public void the_user_navigates_to_plumbing_services() {
        servicesPage = new Plumbing_Service_Page(driver);

        // Step 1: Menu
        servicesPage.clickMenuButton();

        // Step 2: Painting & Cleaning
        servicesPage.clickPaintingCleaning();

        // Step 3: Select Chennai (or any city)
        servicesPage.selectCity();
        servicesPage.clickEPCButton();
        servicesPage.clickPlumbingButton(); 

        // Step 4: Plumbing Category
        servicesPage.clickPlumbingCategory();
    }

    
}