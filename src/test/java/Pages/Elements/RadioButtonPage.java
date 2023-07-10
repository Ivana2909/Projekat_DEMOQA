package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonPage extends BaseTest {
    WebDriver driver;
    List<WebElement> radioButtons;
    WebElement messageSuccess;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getRadioButtons() {
        return driver.findElements(By.className("custom-control-label"));
    }

    public WebElement getMessageSuccess() {
        return driver.findElement(By.className("text-success"));
    }

    //------------------------------
    public void clickOnRadioButton(String nameButton) {
        for (int i = 0; i < getRadioButtons().size(); i++) {
            if (getRadioButtons().get(i).getText().equalsIgnoreCase(nameButton)) {
                getRadioButtons().get(i).click();
                break;

            }
        }
    }
}
