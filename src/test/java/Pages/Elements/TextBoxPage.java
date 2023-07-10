package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    WebDriver driver;
    WebElement fullName;
    WebElement email;
    WebElement currentAddress;
    WebElement permanentAddress;
    WebElement submitButton;
    WebElement informationField;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(By.id("currentAddress"));    }

    public WebElement getPermanentAddress() {
        return driver.findElement(By.id("permanentAddress"));    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getInformationField() {
        return driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));
    }
    //--------------------------------------------

    public void insertFullName(String fullName){
        getFullName().clear();
        getFullName().sendKeys(fullName);
    }
    public void insertEmail(String email){
        getEmail().clear();
        getEmail().sendKeys(email);
    }
    public void inserCurrentAddress(String address){
        getCurrentAddress().clear();
        getCurrentAddress().sendKeys(address);
    }
    public void insertPermanentAddress(String address){
        getPermanentAddress().clear();
        getPermanentAddress().sendKeys(address);
    }
    public void clicOnSubmit(){
        getSubmitButton().click();
    }

}
