package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ItemDetailsPage {
    private final By itemTitle = By.cssSelector(".inventory_details_name.large_size");
    private final By itemImage = By.xpath("//*[@class=\"inventory_details_img_container\"]");
    private final By itemDesc = By.xpath("//*[@class=\"inventory_details_desc large_size\"]");
    private final By itemPrice = By.xpath("//*[@class=\"inventory_details_price\"]");
    private final By getAddToCartButton = By.id("add-to-cart");

    String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4"; // Or retrieve dynamically if needed

    // WebDriver instance
    private final WebDriver driver;
    // Constructor to initialize WebDriver
    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify URL
    public void assertPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "URL does not match expected URL.");
    }

    // Verify Item Details
    public void assertItemDetails() {
        //ItemTitle
        boolean itemTitleIsDisplayed = driver.findElement(itemTitle).isDisplayed();
        Assert.assertTrue(itemTitleIsDisplayed);
        //ItemImage
        boolean itemImageIsDisplayed = driver.findElement(itemImage).isDisplayed();
        Assert.assertTrue(itemImageIsDisplayed);
        //ItemDesc
        boolean itemDescIsDisplayed = driver.findElement(itemDesc).isDisplayed();
        Assert.assertTrue(itemDescIsDisplayed);
        //ItemPrice
        boolean itemPriceIsDisplayed = driver.findElement(itemPrice).isDisplayed();
        Assert.assertTrue(itemPriceIsDisplayed);
        //AddToCartButton
        boolean addToCartButton = driver.findElement(getAddToCartButton).isDisplayed();
        Assert.assertTrue(addToCartButton);




    }
}