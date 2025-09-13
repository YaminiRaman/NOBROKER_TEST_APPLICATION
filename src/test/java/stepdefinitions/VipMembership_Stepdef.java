package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
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
        // ✅ Assert menu opened
        Assert.assertTrue(driver.findElement(vipPage.paintingCleaning).isDisplayed(),
                "❌ Menu did not open properly!");
        System.out.println("✅ Menu opened for plans");
    }

    @When("the user selects Painting and Cleaning for plans")
    public void the_user_selects_painting_and_cleaning() {
        vipPage.clickPaintingAndCleaning();
        vipPage.selectCity();
        // ✅ Assert Painting & Cleaning navigation
        Assert.assertTrue(driver.findElement(vipPage.vipPlans).isDisplayed(),
                "❌ Painting and Cleaning page not visible!");
        System.out.println("✅ Painting and Cleaning page loaded");
    }
    @And("the user views VIP membership plans")
    public void the_user_views_vip_membership_plans() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until the element is visible
        WebElement vipPlansElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vipPage.vipPlans)
        );

        // ✅ Assert VIP Plans are visible
        Assert.assertTrue(vipPlansElement.isDisplayed(), "❌ VIP Plans not visible!");
        System.out.println("✅ VIP Plans visible");
    }


   
}
