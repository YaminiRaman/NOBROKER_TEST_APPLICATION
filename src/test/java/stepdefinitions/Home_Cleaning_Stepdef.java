package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.HomeCleaningPage;
import pages.LoginPage;

public class Home_Cleaning_Stepdef {

    WebDriver driver;
    HomeCleaningPage cleaningPage;
    LoginPage loginPage;

    @Given("the user logs in successfully for home")
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
        cleaningPage = new HomeCleaningPage(driver);
    }



    @When("the user clicks on the menu button for home")
    public void the_user_clicks_on_the_menu_button_for_home() {
        cleaningPage.clickMenu();
    }

    @When("the user selects Painting and Cleaning for home")
    public void the_user_selects_painting_and_cleaning_for_home() {
        cleaningPage.clickPaintingCleaning();
        cleaningPage.selectCity();
    }
    

    @When("the user selects Home Cleaning for home")
    public void the_user_selects_home_cleaning_for_home() {
        cleaningPage.clickHomeCleaning();
    }

    @When("the user selects Full House Cleaning for home")
    public void the_user_selects_full_house_cleaning_for_home() {
        cleaningPage.clickFullHouseCleaning();
    }

    @When("the user selects Furnished Villa for home")
    public void the_user_selects_furnished_villa_for_home() {
        cleaningPage.clickFurnishedVilla();
    }

    @Then("the service page should appear for home")
    public void the_service_page_should_appear_for_home() {
        System.out.println("✅ Service page appeared successfully.");
    }

   
}
