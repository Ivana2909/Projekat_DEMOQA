package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideBarPage extends BaseTest {
    WebDriver driver;
    WebElement elements;
    WebElement practiceForm;
    WebElement alerts_frame_windows;
    WebElement widgets;
    WebElement interactions;
    WebElement bookStoreApplication;
    WebElement toolsQa;


    public SideBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDropDownofSection(String name) {
        List<WebElement> dropDown = driver.findElements(By.cssSelector(".btn.btn-light"));
        int brojac = 0;
        for (int i = 0; i < dropDown.size(); i++) {
            if (dropDown.get(i).getText().equals(name)) {
                scrollIntoView(dropDown.get(i));
                brojac = i;
                break;
            }
        }
        return dropDown.get(brojac);
    }

    //-----------------------------------------------
    public void clickOnSection(String cardName) {
        List<WebElement> cards = driver.findElements(By.className("header-wrapper"));

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardName)) {
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }

    }

    public void clickOnDropDownofSection(String name) {
        List<WebElement> dropDown = driver.findElements(By.cssSelector(".btn.btn-light"));
        for (int i = 0; i < dropDown.size(); i++) {
            if (dropDown.get(i).getText().equals(name)) {
                scrollIntoView(dropDown.get(i));
                dropDown.get(i).click();
                break;
            }
        }
    }

    public void clickOnElement(String name) {
        List<WebElement> elements = driver.findElements(By.className("header-text"));

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(name)) {
                scrollIntoView(elements.get(i));
                elements.get(i).click();
                break;
            }
        }

    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}


