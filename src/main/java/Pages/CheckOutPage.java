package Pages;

import Utilis.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutPage{
    private final By finishButton = By.id("finish");
    private final By confirmationMessage = By.cssSelector(".complete-header");

    // Constructor to initialize WebDriver
    private final WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
    public void getConfirmationMessage(String expectedThankYouText) {
        String actualThankYouText = driver.findElement(confirmationMessage).getText();
        Assert.assertEquals(actualThankYouText, expectedThankYouText);
    }
}
