package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test
    public void goToLoginPage(){
        homePage.clickOnCard(homePage.getBookStoreApplicationText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",1,5));
        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",8,1));
        Assert.assertEquals(logInPage.getTitle().getText(), excelReader.getStringData("Cards", 1, 5));

    }

    @Test
    public void userCanLoginWithValidUsernameAndPassword() throws InterruptedException {
        goToLoginPage();
        String userName=excelReader.getStringData("BookStore",1,0);
        String password=excelReader.getStringData("BookStore",1,1);

        logInPage.insertUserName(userName);
        logInPage.insertPassword(password);
        logInPage.clickOnLoginButton();
        Thread.sleep(2000);
        Assert.assertEquals(profilePage.getUser().getText(),userName);
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());

    }
}
