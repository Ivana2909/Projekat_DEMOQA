package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage{
    WebDriver driver;
    WebElement textBox;
    WebElement buttons;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextBoxText() {
        return "Text Box";
    }

    public String getButtonsText() {
        return "Buttons";
    }

    //-------------------------------------------
    public WebElement clickOnElement(String cardName) {
        List<WebElement> cards = driver.findElements(By.className("text"));

        int brojac = 0;
        for (int i = 0; i < cards.size(); i++) {
             scrollIntoView(cards.get(i));
            if (cards.get(i).getText().equals(cardName)) {
                cards.get(i).click();
                brojac = i;
                break;
            }
        }
        return cards.get(brojac);
    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
