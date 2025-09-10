package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.HomeCleaningPage;
import pages.LoginPage;
import pages.VipMembershipPage;

public class VipMembership_Stepdef {

    WebDriver driver = Hooks.driver; // ✅ Using your Hooks driver
    VipMembershipPage vipPage;
    LoginPage loginPage;

    @Given("the user logs in successfully for VIP Plans")
    public void the_user_logs_in_successfully_for_home() {
        // Use the driver initialized in Hooks
        WebDriver driver = Hooks.driver;

        // Initialize LoginPage with driver
        loginPage = new LoginPage(driver, Hooks.extTest);

        // Perform login actions
        loginPage.clickLogin();
        loginPage.enterMobileNumber("8015888674");
        loginPage.clickContinue();

        // 🔑 Either use static OTP or manual input
        loginPage.enterOtpManually(driver);  // replace with real OTP if needed
        // OR
        // Scanner sc = new Scanner(System.in);
        // String otp = sc.nextLine();
        // loginPage.enterOtp(otp);

        loginPage.clickContinue();

        // Verify login
        Assert.assertTrue(loginPage.loginsuccessful(), "❌ Login failed!");
        System.out.println("✅ User logged in successfully for Home flow");
        vipPage = new VipMembershipPage(driver);
    }


    @When("the user clicks on menu for plans")
    public void the_user_clicks_on_menu() {
        vipPage.clickMenu();
    }

    @When("the user selects Painting and Cleaning for plans")
    public void the_user_selects_painting_and_cleaning() {
        vipPage.clickPaintingAndCleaning();
        vipPage.selectCity();
    }

    @When("the user views VIP membership plans")
    public void the_user_views_vip_membership_plans() {
        vipPage.viewVipPlans();
    }

    @When("the user clicks on Gift Voucher")
    public void the_user_clicks_on_gift_voucher() {
        vipPage.clickGiftVoucher();
    }

    @Then("the user explores available offers")
    public void the_user_explores_available_offers() {
        vipPage.clickExploreOffer();
    }
}
