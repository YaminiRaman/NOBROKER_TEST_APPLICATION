package stepdefinitions;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utils.Base;

public class Hooks extends Base {
	
	static ExtentSparkReporter spark;
	static ExtentReports extReports;
	public static ExtentTest extTest;
	
	LoginPage loginPage;
	
	@BeforeAll
	public static void beforeAll(){
		spark=new ExtentSparkReporter("report/ExtendsReport.html");
		extReports=new ExtentReports();
		extReports.attachReporter(spark);
	}
	
	@AfterAll
	public static void afterAll(){
		extReports.flush();
	}
	
	@Before
	public void setup(Scenario scenario) {
	    lanchBrowser();
	    extTest=extReports.createTest(scenario.getName());
	}
	
	@Before("@home")
	public void loginBeforeHome(Scenario scenario) {
		loginPage = new LoginPage(driver, extTest);
		loginPage.clickLogin();
		loginPage.enterMobileNumber("8015888674");  
		loginPage.enterOtpManually(driver); 
		loginPage.clickContinue();
	}
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        extTest.log(Status.FAIL, "Scenario failed: " + scenario.getName());
	    } else {
	        extTest.log(Status.PASS, "Scenario passed: " + scenario.getName());
	    }
	}

	@After
	public static void tearDown(){
		Base.sleep();
		driver.quit();
	}
	
}