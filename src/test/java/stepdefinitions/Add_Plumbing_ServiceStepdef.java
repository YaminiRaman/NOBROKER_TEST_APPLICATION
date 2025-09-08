package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.Add_Plumbing_ServicePage;

public class Add_Plumbing_ServiceStepdef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Add_Plumbing_ServicePage addServicePage;

    @Given("the user logs in with a valid mobile number and OTP for booking")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
    }

    @Given("the user navigates to plumbing services page for booking")
    public void the_user_navigates_to_plumbing_services_page_for_booking() {
        addServicePage = new Add_Plumbing_ServicePage(driver);
        addServicePage.navigateToPlumbingServicesForBooking();
    }

    @When("the user selects a plumbing service and clicks add")
    public void the_user_selects_a_plumbing_service_and_clicks_add() {
        addServicePage.clickAddButtonMultipleTimes("Book a Plumber", 2);
    }




    @Then("the selected plumbing service should be added successfully with quantity {int}")
    public void the_selected_plumbing_service_should_be_added_successfully_with_quantity(Integer quantity) {
        Assert.assertTrue(
            addServicePage.isServiceAddedSuccessfully(quantity),
            "Plumbing service was not added successfully with quantity " + quantity + "!"
        );
    }
}
