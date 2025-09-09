package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
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
        System.out.println("✅ User logged in successfully");
    }

    @Given("the user navigates to plumbing services page for booking")
    public void the_user_navigates_to_plumbing_services_page_for_booking() {
        addServicePage = new Add_Plumbing_ServicePage(driver);

        addServicePage.clickMenuButton();
        addServicePage.clickPaintingCleaning();
        addServicePage.selectCity();
        addServicePage.clickEPCButton();
        addServicePage.clickPlumbingButton();
        addServicePage.clickPlumbingCategory();

        System.out.println("✅ Navigated to plumbing services page");
    }
    

    
}
