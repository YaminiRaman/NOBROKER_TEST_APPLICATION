package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SubscriptionPage;
import utils.Base;

public class Subscription_Stepdef extends Base {

    LoginPage loginPage;
    SubscriptionPage tenantPlansPage;

    @Given("the user is logged in")
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

        tenantPlansPage = new SubscriptionPage(driver);
    }

    @When("the user navigates to Tenant Plans and selects Freedom Plan")
    public void the_user_navigates_to_tenant_plans_and_selects_freedom_plan() {
        tenantPlansPage.clickMenu();
        tenantPlansPage.clickTenantPlans();

        // ✅ Assert Subscribe button is visible before clicking
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement subscribeBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='payPlanType']"))
        );

        Assert.assertTrue(subscribeBtn.isDisplayed(), "❌ Freedom Plan Subscribe button not visible!");
        System.out.println("✅ Freedom Plan Subscribe button is visible");

        tenantPlansPage.clickFreedomPlanSubscribe();
        System.out.println("✅ Freedom Plan Subscribe button clicked");
    }

}
