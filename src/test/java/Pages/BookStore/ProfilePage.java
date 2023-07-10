package Pages.BookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    WebDriver driver;
    WebElement logOutButton;
    WebElement user;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getUser() {
        return driver.findElement(By.id("userName-value"));
    }
    //----------------------------------

}
