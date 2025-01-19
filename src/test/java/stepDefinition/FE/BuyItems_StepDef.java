package stepDefinition.FE;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.InformationPage;
import Utilis.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BuyItems_StepDef {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    CheckOutPage checkoutPage;
    InformationPage informationPage;
    @Before
    public void setUp() {
        driver = TestBase.initializeDriver();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckOutPage(driver);
        informationPage = new InformationPage(driver);
    }
    @When("I click Add to Cart")
    public void i_click_add_to_cart()  {
        homePage.clickAddToCart();
    }
    @When("I click on the cart icon")
    public void i_click_on_the_cart_icon() {

        homePage.clickOnCartIcon();
    }
    @And("Verify That Item has been added to the cart")
    public void verify_that_item_has_been_added_to_the_cart(){

        cartPage.assertThatItemAddedInCart();
    }
    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        cartPage.clickOnCheckOutButton();
    }
    @And("I enter my information")
    public void i_enter_my_information() {
        informationPage.assertInformationPage();
        informationPage.fillFirstName();
        informationPage.fillLastName();
        informationPage.fillPostalCode();
        informationPage.clickContinueButton();
    }

    @And("I complete the purchase")
    public void i_complete_the_purchase() {
        checkoutPage.clickFinishButton();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedThankYouText){
        checkoutPage.getConfirmationMessage(expectedThankYouText);
        TestBase.quitDriver();
    }
}
