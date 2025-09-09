package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.Showmore_Plumbing_Page;

public class Showmore_Plumbing_Stepdef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Showmore_Plumbing_Page servicesPage;

    @Given("the user logs in successfully with valid credentials")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        // ✅ Login flow
        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "❌ Login failed!");
        System.out.println("✅ User logged in successfully.");
    }

    @And("the user navigates to the plumbing services section")
    public void the_user_navigates_to_the_plumbing_services_section() {
        servicesPage = new Showmore_Plumbing_Page(driver);
        servicesPage.clickMenuButton();
        servicesPage.clickPaintingCleaning();
        servicesPage.selectCity();
        servicesPage.clickEPCButton();
        servicesPage.clickPlumbingButton();   // ✅ fixed
    }

    @When("the user scrolls through the available plumbing services")
    public void the_user_scrolls_through_the_available_plumbing_services() {
        boolean visible = servicesPage.isServiceDetailsVisible(); // ✅ fixed
        Assert.assertTrue(visible, "❌ Plumbing services not visible after navigation!");
        System.out.println("✅ Plumbing services are visible.");
    }

    @And("the user clicks on {string} for a selected service")
    public void the_user_clicks_on_for_a_selected_service(String serviceName) {
        System.out.println("Clicking on service: " + serviceName);
        servicesPage.clickBookPlumber();
        servicesPage.clickShowMore();
    }


    @Then("the service description and pricing details should be displayed")
    public void the_service_description_and_pricing_details_should_be_displayed() {
        boolean detailsVisible = servicesPage.isServiceDetailsVisible(); // ✅ fixed
        Assert.assertTrue(detailsVisible, "❌ Service description and pricing details are NOT visible!");
        System.out.println("✅ Service details are displayed correctly.");
    }
}
