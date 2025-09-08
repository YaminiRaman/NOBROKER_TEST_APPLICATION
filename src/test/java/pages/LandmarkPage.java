package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
            wait.until(ExpectedConditions.elementToBeClickable(By.id("searchCity"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'nb-select__menu')]//div[text()='" + cityName + "']"))).click();

            extTest.log(Status.PASS, "City selected: " + cityName);
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to select city: " + e.getMessage());
            throw e;
        }
    }

    public void enterLocality(String locality) {
        try {
            WebElement localityInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("listPageSearchLocality"))
            );
            localityInput.click();
            if (!locality.isEmpty()) {
                localityInput.sendKeys(locality);
                Base.sleep();
                localityInput.sendKeys(Keys.ARROW_DOWN);
                Base.sleep();
                localityInput.sendKeys(Keys.ENTER);
                extTest.log(Status.PASS, "Locality entered: " + locality);
            } else {
                extTest.log(Status.INFO, "Locality field left blank");
            }
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to handle locality: " + e.getMessage());
            throw e;
        }
    }

    public void clickSearchButton() {
        try {
            driver.findElement(Locators.searchButton).click();
            extTest.log(Status.PASS, "Search button clicked successfully");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isLocalityErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertMessageBox")));
            extTest.log(Status.PASS, "Alert message displayed");
            return true;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Error message not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean redirectedRentPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@itemprop='item']")));
            extTest.log(Status.PASS, "Redirected to Rent Page successfully");
            return true;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to redirect: " + e.getMessage());
            return false;
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

    public boolean isSearchHistoryItemVisible(String location, String locality) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//span[text()='" + locality + ", " + location + "']")
            ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
