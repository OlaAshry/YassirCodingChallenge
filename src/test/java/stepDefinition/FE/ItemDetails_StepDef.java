package stepDefinition.FE;

import Pages.HomePage;
import Pages.ItemDetailsPage;
import Utilis.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ItemDetails_StepDef {
    WebDriver driver;
    HomePage homePage;
    ItemDetailsPage itemDetailsPage;

    @Before
    public void setUp() {
        driver = TestBase.initializeDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
        homePage = new HomePage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
    }
    @When("I click on an item")
    public void i_click_on_an_item() {
        homePage.assertLoggedIn();
        homePage.clickOnItem();
    }

    @Then("I can view the details successfully")
    public void iCanViewTheDetailsSuccessfully() {
        itemDetailsPage.assertPageUrl();
        itemDetailsPage.assertItemDetails();
        TestBase.quitDriver();
    }
}
