package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class ButtonsPage {
    WebDriver driver;
    WebElement doubleClickButton;
    WebElement rightClickButton;
    WebElement clickButton;
    Actions act;
    Actions action;
    WebElement title;
    WebElement messageForRightClick;
    WebElement messageForDoubleClick;
    WebElement messageForClick;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        act = new Actions(driver);
        action = new Actions(driver);
    }

    public WebElement getDoubleClickButton() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClickButton() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getClickButton() {
       return driver.findElement(By.id("dynamicClickMessage"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("main-header"));
    }

    public WebElement getMessageForRightClick() {
        return driver.findElement(By.id("rightClickMessage"));
    }

    public WebElement getMessageForDoubleClick() {
        return driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getMessageForClick() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }

    //--------------------------------------
    public void oneClick() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Click Me")) {
                buttons.get(i).click();
                break;
            }
            //  getClickButton().click();
        }
    }

    public void doubleClick() {
        act.doubleClick(getDoubleClickButton()).perform();

    }

    public void rightClick() {
        action.contextClick(getRightClickButton()).perform();
    }

    public String getTitleText() {
      return  getTitle().getText();

    }

}
