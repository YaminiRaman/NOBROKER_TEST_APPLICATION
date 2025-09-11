package stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandmarkPage;


public class Landmark_Stepdef {
	
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	
	
	LandmarkPage homePage;
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@Given("the user selects location {string}")
	public void the_user_selects_location(String location) {
		homePage = new LandmarkPage(driver, extTest);
	    homePage.selectCity(location);
	}
	
	@When("enters landmark {string}")
	public void enters_landmark(String locality) {
	    homePage.enterLocality(locality);
	}
	
	@When("clicks on search button")
	public void clicks_on_search_button() {
		homePage.clickSearchButton();
	}
	
	



	
	@When("leaves the landmark field blank")
	public void leaves_the_landmark_field_blank() {
		homePage.enterLocality("");
	}
	
	
	@When("the user returns to the home page")
    public void the_user_returns_to_the_home_page() {
        driver.navigate().to("https://www.nobroker.in/");  // or use your HomePage.openHomePage()
        driver.navigate().refresh();
    }

	
	
}