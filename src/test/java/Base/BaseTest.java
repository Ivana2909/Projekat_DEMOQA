package Base;

import Pages.*;
import Pages.Alerts.AlertsPage;
import Pages.BookStore.LogInPage;
import Pages.BookStore.ProfilePage;
import Pages.Elements.*;
import Pages.Forms.PracticeFormsPage;
import Pages.Widgets.AutoCompletePage;
import Pages.Widgets.ProgressBarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    //excel reader za integer, radio button,

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public ExcelReader excelReader;
    public SideBarPage sideBarPage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public ButtonsPage buttonsPage;
    public PracticeFormsPage practiceFormsPage;
    public JavascriptExecutor js;
    public AlertsPage alertsPage;
    public ProgressBarPage progressBarPage;
    public Actions actions;
    public UploadAndDownloadPage uploadAndDownloadPage;
    //mozda ne treba??
    public FluentWait fluentWait;
    public RadioButtonPage radioButtonPage;
    public AutoCompletePage autoCompletePage;
    public LogInPage logInPage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        excelReader = new ExcelReader("C:\\Users\\ivana\\OneDrive\\Desktop\\ITBootCamp\\TestDataForProject.xlsx");
        sideBarPage = new SideBarPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage=new TextBoxPage(driver);
        buttonsPage=new ButtonsPage(driver);
        practiceFormsPage=new PracticeFormsPage(driver);
        js = (JavascriptExecutor) driver;
        alertsPage=new AlertsPage(driver);
        progressBarPage=new ProgressBarPage(driver);
        actions=new Actions(driver);
        uploadAndDownloadPage=new UploadAndDownloadPage(driver);
        fluentWait=new FluentWait(driver);
        radioButtonPage=new RadioButtonPage(driver);
        autoCompletePage=new AutoCompletePage(driver);
        logInPage=new LogInPage(driver);
        profilePage=new ProfilePage(driver);
    }

     public void scrollIntoView(WebElement element) {
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
     }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) throws Exception{
        boolean nonexistingElement = false;
        try {
            nonexistingElement = element.isDisplayed(); //ako jeste dispayed onda se boolean menja u true
        } catch (Exception e) {
        }
        return nonexistingElement;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public void saveImage(WebElement element) throws IOException {
        wait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\ivana\\Desktop\\";
        ImageIO.write(saveImage, "png", new File(location + System.currentTimeMillis() + ".png"));
    }
    public void selectAll(WebElement element) {
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        element.sendKeys(selectAll);
    }
    public void ESCAPE(){
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    @AfterClass
    public void tearDown() {
        //  driver.manage().deleteAllCookies();
        // driver.quit();

    }


}
