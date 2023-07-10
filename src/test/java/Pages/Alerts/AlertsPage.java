package Pages.Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsPage {
    WebDriver driver;
    WebElement alertButton;
    WebElement timeAlertButton;
    WebElement ConfirmBoxAlert;
    WebElement PromptBoxAlert;
    WebElement confirmMessage;
    WebElement pomptUpMessage;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAlertButton() {
        return driver.findElement(By.id("alertButton"));
    }

    public WebElement getTimeAlertButton() {
        return driver.findElement(By.id("timerAlertButton"));
    }

    public WebElement getConfirmBoxAlert() {
        return driver.findElement(By.id("confirmButton"));
    }

    public WebElement getPromptBoxAlert() {
        return driver.findElement(By.id("promtButton"));
    }

    public WebElement getConfirmMessage() {
        return driver.findElement(By.id("confirmResult"));
    }

    public WebElement getPomptUpMessage() {
        return driver.findElement(By.id("promptResult"));

    }

    //-------------------------------------------------------
    public void clikcOnAlertButton(){
        getAlertButton().click();
    }
    public void clickOnTimeAlertButton(){
        getTimeAlertButton().click();
    }
    public void clickOnConfirmBoxButton(){
        getConfirmBoxAlert().click();
    }
    public void clickOnPromptBoxButton() {
        getPromptBoxAlert().click();
    }
        public void clickOkButtonOnAlert(){
        driver.switchTo().alert().accept();

        }
        public void clickCancelButtonOnAlert(){
        driver.switchTo().alert().dismiss();
        }
        public void enterTextIntoAlert(String text){
        driver.switchTo().alert().sendKeys(text);
        }
    }

