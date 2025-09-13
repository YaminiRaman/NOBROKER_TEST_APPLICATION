package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
       // Menu button assert
       WebElement menuBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main-menu']/div[1]/img")));
       Assert.assertTrue(menuBtn.isDisplayed(), "❌ Menu button not visible!");
       subscriptionPage.clickMenu();
       System.out.println("✅ Menu button clicked and visible");

       // Tenant Plans button assert
       WebElement tenantPlansBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main-menu']/div[2]/a[7]")));
       Assert.assertTrue(tenantPlansBtn.isDisplayed(), "❌ Tenant Plans button not visible!");
       subscriptionPage.clickTenantPlans();
       System.out.println("✅ Tenant Plans button clicked and visible");

       // Freedom Plan Subscribe button assert
       WebElement freedomSubscribeBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='payPlanType']")));
       Assert.assertTrue(freedomSubscribeBtn.isDisplayed(), "❌ Freedom Plan Subscribe button not visible!");
       subscriptionPage.clickFreedomPlanSubscribe();
       System.out.println("✅ Freedom Plan Subscribe button clicked, payment page opened");
   }

   @When("the user cancels the payment")
   public void the_user_cancels_the_payment() {
       // Back button assert
       WebElement backBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/header/div[1]/div[1]/div[2]")));
       Assert.assertTrue(backBtn.isDisplayed(), "❌ Back button not visible!");
       subscriptionPage.clickBackButton();
       System.out.println("✅ Back button clicked");

       // Cancel payment Yes button assert
       WebElement yesBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/button[1]")));
       Assert.assertTrue(yesBtn.isDisplayed(), "❌ Cancel payment Yes button not visible!");
       subscriptionPage.confirmCancelPayment();
       System.out.println("✅ Payment cancel confirmed");
   }


    
}
