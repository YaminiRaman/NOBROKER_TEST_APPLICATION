package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.PaymentcancelPage;
import pages.SubscriptionPage;
import utils.Base;

public class Payment_Cancel_Stepdef extends Base {

    LoginPage loginPage;
   PaymentcancelPage subscriptionPage;

   @Given("the user is logged in for payment cancel")
   public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
       driver.get("https://www.nobroker.in/");

       loginPage = new LoginPage(driver, Hooks.extTest);

       loginPage.clickLogin();
       loginPage.enterMobileNumber("8015888674");
       loginPage.clickContinue();
       loginPage.enterOtpManually(driver);
       loginPage.clickContinue();

       Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
       System.out.println("✅ User logged in successfully");

       subscriptionPage = new PaymentcancelPage(driver);
   }
    @When("the user navigates to Tenant Plans and selects Freedom Plan for view plans")
    public void the_user_navigates_to_tenant_plans_and_selects_freedom_plan_for_view_plans() {
        subscriptionPage.clickMenu();
        subscriptionPage.clickTenantPlans();
        subscriptionPage.clickFreedomPlanSubscribe();
        System.out.println("✅ Freedom Plan Subscribe button clicked, payment page opened");
    }

    @When("the user cancels the payment")
    public void the_user_cancels_the_payment() {
        subscriptionPage.clickBackButton();
        subscriptionPage.confirmCancelPayment();
        System.out.println("✅ Payment cancel confirmed");
    }

    
}
