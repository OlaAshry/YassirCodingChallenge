package Pages;

import Utilis.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage{
    private final By item = By.id("item_4_title_link");
    private final By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.className("shopping_cart_link");
    private final String homePageUrl = "https://www.saucedemo.com/inventory.html";

    // Constructor to initialize WebDriver
   private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void assertLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, homePageUrl);
    }
    public void clickAddToCart() {
        driver.findElement(addToCart).click();
    }
    public void clickOnCartIcon() {

        driver.findElement(cartIcon).click();
    }

    public void clickOnItem() {
        driver.findElement(item).click();
    }
}
