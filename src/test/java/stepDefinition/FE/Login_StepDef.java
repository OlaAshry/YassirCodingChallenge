package stepDefinition.FE;

import Pages.HomePage;
import Pages.loginPage;
import Utilis.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_StepDef{
    WebDriver driver;
    loginPage loginPage;
    HomePage homePage;
    @Before
    public void setUp() {
        driver = TestBase.initializeDriver();
        loginPage = new loginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I open Swag Labs website")
    public void openSwagLabsWebsite(){
     loginPage.openWebsite();
    }
    @When("I enter username {string} and password {string}")
    public void enterLoginCredentials(String username,String password)
    {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);

    }
    @And("I click on the login button")
    public void clickOnLoginButton(){
        loginPage.clickLogin();
    }
    @Then("I should see the result {string}")
    public void userLandOnDashboard(String result){
        if (result.equals("Products page displayed")) {
            homePage.assertLoggedIn();
        } else {
            String ActualErrorMessage =loginPage.getErrorMessage();
            Assert.assertEquals(result,ActualErrorMessage);

        }
        TestBase.quitDriver();
    }
}
