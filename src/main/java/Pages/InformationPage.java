package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformationPage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    String expectedInformationPageUrl = "https://www.saucedemo.com/checkout-step-one.html";


    // Constructor to initialize WebDriver
    private final WebDriver driver;
    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void assertInformationPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedInformationPageUrl);
    }
    public void fillFirstName() {
        driver.findElement(firstName).sendKeys("test");
    }
    public void fillLastName() {

        driver.findElement(lastName).sendKeys("testing");
    }
    public void fillPostalCode() {

        driver.findElement(postalCode).sendKeys("123");
    }
    public void clickContinueButton() {

        driver.findElement(continueButton).click();
    }

}
