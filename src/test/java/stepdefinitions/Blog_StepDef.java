package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Blog_Page;
import pages.LoginPage;


public class Blog_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Blog_Page blogPage;

  

    @When("the user navigates to Interiors -> Renovation")
    public void the_user_navigates_to_interiors_renovation() {
        blogPage = new Blog_Page(driver);
        blogPage.navigateToRenovationBlogs();
        System.out.println("✅ Navigated to Interiors -> Renovation");
    }

   
}