package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container");
    String url = "https://www.saucedemo.com/";

    // Constructor to initialize WebDriver
    private final WebDriver driver;
    public loginPage(WebDriver driver){
       this.driver = driver;
    }

    public void openWebsite(){
        driver.navigate().to(url);
    }
    public void enterUserName(String username){

        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){

        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();
    }


}
