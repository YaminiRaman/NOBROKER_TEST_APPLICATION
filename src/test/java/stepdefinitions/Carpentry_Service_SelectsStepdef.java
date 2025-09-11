package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Carpentry_Service_SelectPage;
import pages.LoginPage;

public class Carpentry_Service_SelectsStepdef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Carpentry_Service_SelectPage servicesPage;

   

    
    

    @When("the user navigates to carpentry services")
    public void the_user_navigates_to_carpentry_services() {
        servicesPage = new Carpentry_Service_SelectPage(driver);

        servicesPage.clickMenuButton();
        servicesPage.clickPaintingCleaning();
        servicesPage.selectCity();
        servicesPage.clickEPCButton();
        servicesPage.clickCarpentryCategory();
        // 👇 Do NOT click the first service here
        System.out.println("✅ User navigated to carpentry category.");
    }

    @Then("the user selects the first carpentry service")
    public void the_user_selects_the_first_carpentry_service() {
        servicesPage.clickFirstCarpentryService();
        System.out.println("✅ User selected the first carpentry service.");
    }




}
