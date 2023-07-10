package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));


    }

    @Test(priority = 5)
    public void allElementsAreVisible() {
        Assert.assertTrue(homePage.getSeleniumTraining().isDisplayed());
        Assert.assertTrue(homePage.getToolsQa().isDisplayed());
        homePage.cardIsVisble(homePage.getElementsText());
        homePage.cardIsVisble(homePage.getFormsText());
        homePage.cardIsVisble(homePage.getInteractionsText());
        homePage.cardIsVisble(homePage.getWidgetsText());
        homePage.cardIsVisble(homePage.getBookStoreApplicationText());
        homePage.cardIsVisble(homePage.getAlerts_frame_windowsText());
    }

    @Test(priority = 10)
    public void cardWidgetsIsClickable() {
        //Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        homePage.clickOnCard(homePage.getWidgetsText());
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 6));
        homePage.clickOnToolsQa();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }
    @Test(priority = 20)
    public void cardElementsIsClickable(){
        //Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

        homePage.clickOnCard(homePage.getElementsText());
        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",1,1));

    }

    @AfterMethod
    public void goOnHomePage(){
        homePage.clickOnToolsQa();
    }
}
