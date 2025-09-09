package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
	static ExtentTest extTest;
	
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
		loginPage.enterMobileNumber("7812886595");  
		loginPage.enterOtpManually(driver); 
		loginPage.clickContinue();
	}

	@After
	public static void tearDown(){
		Base.sleep();
		driver.quit();
	}
}