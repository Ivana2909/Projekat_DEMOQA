package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BaseTest {
    WebDriver driver;
    WebElement elements;
    WebElement forms;
    WebElement alerts_frame_windows;
    WebElement widgets;
    WebElement interactions;
    WebElement bookStoreApplication;
    WebElement toolsQa;
    WebElement seleniumTraining;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public String getElementsText() {
        return "Elements";
    }

    public String getFormsText() {
        return "Forms";
    }

    public String getAlerts_frame_windowsText() {
        return "Alerts, Frame & Windows";
    }

    public String getWidgetsText() {
        return "Widgets";
    }

    public String getInteractionsText() {
        return "Interactions";
    }

    public String getBookStoreApplicationText() {
        return "Book Store Application";
    }

    public WebElement getToolsQa() {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
    }

    public WebElement getSeleniumTraining() {
        return driver.findElement(By.className("banner-image"));
    }

    //----------------------------------------------
    public void clickOnCard(String cardName) {
        List<WebElement> cards = driver.findElements(By.className("card-body"));

        for (int i = 0; i < cards.size(); i++) {
            scrollIntoView(cards.get(i));
            if (cards.get(i).getText().equals(cardName)) {
                cards.get(i).click();
                break;
            }
        }
    }

    public WebElement cardIsVisble(String cardName){
        List<WebElement> cards = driver.findElements(By.className("card-body"));

        int brojac = 0;
        for (int i = 0; i < cards.size(); i++) {
            scrollIntoView(cards.get(i));
            if (cards.get(i).getText().equals(cardName)) {
                Assert.assertTrue(cards.get(i).isDisplayed());
                brojac = i;
                break;
            }
        }
        return cards.get(brojac);
    }

    public void clickOnToolsQa(){
        getToolsQa().click();
    }
    public void clickOnSeleniumTraining(){
        getSeleniumTraining().click();
    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
