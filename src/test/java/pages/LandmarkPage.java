package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Base;

public class LandmarkPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public LandmarkPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public void selectCity(String cityName) {
		try {
			// Click the dropdown to open options
			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchCity"))).click();

			// Wait for options to appear and select the desired city
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[contains(@class,'nb-select__menu')]//div[text()='" + cityName + "']"))).click();

			extTest.log(Status.PASS, "City selected: " + cityName);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select city: " + e.getMessage());
		}
	}

	public void enterLocality(String locality) {
		try {
			WebElement localityInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("listPageSearchLocality")));
			localityInput.click();
			localityInput.sendKeys(locality);
			Base.sleep();
			localityInput.sendKeys(Keys.ARROW_DOWN);
			Base.sleep();
			localityInput.sendKeys(Keys.ENTER);

			extTest.log(Status.PASS, "Locality selected: " + locality);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select locality: " + e.getMessage());
		}
	}

	public void clickSearchButton() {
	    try {
	        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchButton));
	        searchBtn.click();
	        extTest.log(Status.PASS, "Search button clicked successfully");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
	    }
	}


	


	

	public boolean isHistorySectionVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.historySection));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	



	
}