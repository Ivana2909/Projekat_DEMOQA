package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutoCompletePage extends BaseTest {
    WebDriver driver;
    WebElement multipleAutoComplite;
    WebElement singleAutoComplite;
    WebElement title;
    WebElement singleText;
    WebElement multipleText;

    public AutoCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMultipleAutoComplite() {
        return driver.findElement(By.id("autoCompleteMultipleInput"));
    }

    public WebElement getSingleAutoComplite() {
        return driver.findElement(By.id("autoCompleteSingleInput"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("main-header"));
    }

    public WebElement getSingleText() {
        return driver.findElement(By.cssSelector(".auto-complete__single-value.css-1uccc91-singleValue"));
    }

    public WebElement getMultipleText() {
        return driver.findElement(By.cssSelector(".css-12jo7m5.auto-complete__multi-value__label"));
    }
    //-------------------------------------

    public void clickOnMulipleAutoCompleteField() {
        getMultipleAutoComplite().click();
        getMultipleAutoComplite().clear();
    }
    public void enterColors(String color) {

       // for (int i = 0; i < excelReader.getLastRow("Colors"); i++) {
          //  String color = excelReader.getStringData("Colors", 0, i);
            getMultipleAutoComplite().sendKeys(color);
            getMultipleAutoComplite().sendKeys(Keys.ENTER);
        }
        public void enterSingleColor(String color){
        getSingleAutoComplite().click();
        getSingleAutoComplite().clear();
        getSingleAutoComplite().sendKeys(color);
        getSingleAutoComplite().sendKeys(Keys.ENTER);
        }
 // za assertaciju da uhvati text koji je iskucan
        public String TextInField(){
        List<WebElement> colorList=driver.findElements(By.cssSelector(".css-12jo7m5.auto-complete__multi-value__label"));
        String colors="";
        for(int i=0;i< colorList.size();i++){
           colors+=colorList.get(i).getText();
        }
        return colors;
        }
    }

