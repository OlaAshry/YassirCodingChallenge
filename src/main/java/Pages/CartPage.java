package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private final By item = By.className("cart_item_label");
    private final By checkOutButton = By.id("checkout");


    // Constructor to initialize WebDriver
    private final WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertThatItemAddedInCart(){
        Assert.assertTrue(driver.findElement(item).isDisplayed());
    }
    public void clickOnCheckOutButton() {

        driver.findElement(checkOutButton).click();
    }
}
