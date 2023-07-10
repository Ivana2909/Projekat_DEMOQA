package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ProgressBarPage extends BaseTest {
    WebDriver driver;
    WebElement progressBar;
    WebElement button;
    WebElement resetButton;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProgressBar() {
        return driver.findElement(By.id("progressBar"));
    }

    public WebElement getButton() {
        return driver.findElement(By.id("startStopButton"));
    }

    public WebElement getResetButton() {
        if(getButton().getText().equals("Reset"));
        return driver.findElement(By.cssSelector(".mt-3.btn.btn-primary"));
    }
    //--------------------------------------

    public void clickOnButtonForStartOrStopProgressBar(){
        getButton().click();
    }


    public void waitForFinish(){

//Specify the timout of the wait
        wait.withTimeout(Duration.ofSeconds(15));
//Specify polling time
        wait.pollingEvery(Duration.ofSeconds(1));
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

        waitForVisibility(getResetButton());
        }
    }

