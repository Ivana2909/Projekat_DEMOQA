package Test.ElementsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority=10)
    public void goToButtonsPage() {
        homePage.clickOnCard(homePage.getElementsText());
       sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",5,0));
        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",5,1));
        Assert.assertEquals(buttonsPage.getTitleText(),excelReader.getStringData("Cards",5,0));
    }
    @Test(priority=30)
    public void userCanClickOnRightButton(){
        goToButtonsPage();
        buttonsPage.rightClick();
        Assert.assertTrue(buttonsPage.getMessageForRightClick().isDisplayed());
        Assert.assertEquals(buttonsPage.getMessageForRightClick().getText(),"You have done a right click");
    }

    @Test(priority=20)
    public void userCanDoubleClick() {
        goToButtonsPage();
        buttonsPage.doubleClick();
        Assert.assertTrue(buttonsPage.getMessageForDoubleClick().isDisplayed());
        Assert.assertEquals(buttonsPage.getMessageForDoubleClick().getText(),"You have done a double click");
    }
    @Test(priority=40)
    public void userCanClick() {
        goToButtonsPage();
        buttonsPage.oneClick();
        Assert.assertTrue(buttonsPage.getMessageForClick().isDisplayed());
        Assert.assertEquals(buttonsPage.getMessageForClick().getText(),"You have done a dynamic click");
    }

}
