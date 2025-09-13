package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.SalesAgreementPage;

public class Salesagreement_Stepdef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    SalesAgreementPage salesPage;

    @Given("the user logs in with a valid mobile number and OTP for sales")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp_for_sales() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "❌ Login failed!");
        System.out.println("✅ User logged in successfully for Sales flow");
    }

    @When("the user navigates to Sales Agreement and selects a package")
    public void the_user_navigates_to_sales_agreement_and_selects_a_package() {
        salesPage = new SalesAgreementPage(driver);

        salesPage.clickMenuButton();
        salesPage.clickPaintingAndCleaning();
        salesPage.selectCity();
        salesPage.clickSalesAgreement();
        salesPage.clickExploreAllServices();
        salesPage.selectPackage();
        salesPage.clickBuyNow();
    }


    @When("the user clicks on Pay button")
    public void the_user_clicks_on_pay_button() {
        boolean payClicked = salesPage.clickPay();
        Assert.assertTrue(payClicked, "❌ Pay button was not clicked successfully!");
        System.out.println("✅ Pay button clicked successfully");
    }

    @When("the user clicks on Back button")
    public void the_user_clicks_on_back_button() {
        boolean backClicked = salesPage.clickBack();
        Assert.assertTrue(backClicked, "❌ Back button was not clicked successfully!");
        System.out.println("✅ Back button clicked successfully");
    }

    @Then("the user confirms cancel payment")
    public void the_user_confirms_cancel_payment() {
        boolean cancelConfirmed = salesPage.confirmCancel();
        Assert.assertTrue(cancelConfirmed, "❌ Cancel payment was not confirmed!");
        System.out.println("✅ Cancel payment confirmed successfully");
    }

    @Then("the browser is closed")
    public void the_browser_is_closed() {
        salesPage.closeBrowser();
        // Optional: simple assert to check driver is null or closed
        // This can be tricky; usually we just ensure no exception occurs
        System.out.println("✅ Browser closed successfully");
    }

}
