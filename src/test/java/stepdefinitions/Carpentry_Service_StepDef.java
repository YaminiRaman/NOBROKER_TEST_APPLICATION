package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class Carpentry_Service_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Carpentry_ServicePage  servicesPage;

    @Given("the user logs in with a valid mobile number and OTP for carpentry service ")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();

        // OTP handled manually from console
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "❌ Login failed!");
        System.out.println("✅ Login successful.");
    }

    @When("the user navigates to plumbing services")
    public void the_user_navigates_to_plumbing_services() {
        servicesPage = new Plumbing_Service_Page(driver);

        servicesPage.clickMenuButton();
        servicesPage.clickPaintingCleaning();
        servicesPage.selectCity();
        servicesPage.clickPlumbingCategory();
    }

    @Then("the plumbing services should be displayed")
    public void the_plumbing_services_should_be_displayed() {
        Assert.assertTrue(servicesPage.isPlumbingServicesVisible(), "❌ Plumbing services not visible!");
        System.out.println("✅ Plumbing services displayed.");
    }
}
