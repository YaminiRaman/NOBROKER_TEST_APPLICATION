package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.Plumbing_Service_Page;
import utils.Base;

public class Plumbing_Service_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Plumbing_Service_Page plumbingPage;

    // ---------------- LOGIN ----------------
    @Given("the user logs in with a valid mobile number and OTP")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();
        loginPage.enterOtpManually(driver);
        // wait 3 sec for OTP verification
       
        loginPage.clickContinue();

        // wait for login success element
        boolean loggedIn = loginPage.loginsuccessful();
        Assert.assertTrue(loggedIn, "❌ Login failed!");
        System.out.println("✅ User logged in successfully.");
    }

    // ---------------- NAVIGATION ----------------
    @When("the user navigates to the plumbing services {string}")
    public void the_user_navigates_to_the_plumbing_services(String target) {
        plumbingPage = new Plumbing_Service_Page(driver);

        plumbingPage.clickMenuButton();
        plumbingPage.clickPaintingCleaning();
        plumbingPage.selectCity();
        plumbingPage.clickEPCButton();
        plumbingPage.clickPlumbingButton();

        if (target.equalsIgnoreCase("section")) {
            System.out.println("✅ Navigated to plumbing services section.");
        } else if (target.equalsIgnoreCase("booking page")) {
            plumbingPage.clickPlumbingCategory();
            System.out.println("✅ Navigated to plumbing services booking page.");
        } else {
            throw new IllegalArgumentException("❌ Unknown navigation target: " + target);
        }
    }
 // ---------------- SERVICE FLOW ----------------
    @Then("the user clicks show more button")
    public void the_user_clicks_show_more_button() {
        plumbingPage.clickShowMore();
        System.out.println("✅ User clicked on Show More button.");
    }


    // ---------------- ASSERTIONS ----------------
  

    // ---------------- SERVICE FLOW ----------------
   
}
