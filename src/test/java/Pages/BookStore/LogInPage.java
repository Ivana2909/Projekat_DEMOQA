package Pages.BookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement logInButton;
    WebElement title;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.id("login"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("main-header"));
    }

    //-------------------------------
    public void insertUserName(String username){
        getUsername().clear();
        getUsername().sendKeys(username);
    }

    public void insertPassword(String pass){
        getPassword().clear();
        getPassword().sendKeys(pass);
    }
    public void clickOnLoginButton(){
        getLogInButton().click();
    }
}
