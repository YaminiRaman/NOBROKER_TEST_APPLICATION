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
        salesPage.clickPay();
    }

    @When("the user clicks on Back button")
    public void the_user_clicks_on_back_button() {
        salesPage.clickBack();
    }

    @Then("the user confirms cancel payment")
    public void the_user_confirms_cancel_payment() {
        salesPage.confirmCancel();
    }

    @Then("the browser is closed")
    public void the_browser_is_closed() {
        salesPage.closeBrowser();
    }
}
