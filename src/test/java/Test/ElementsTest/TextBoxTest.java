package Test.ElementsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority = 10)
    public void goToTextBoxPage(){
        homePage.clickOnCard(homePage.getElementsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",1,0));
        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",5,0));
    }
    @Test(priority = 20)
    public void UserCanSubmitInformation(){
        goToTextBoxPage();
        textBoxPage.insertFullName(excelReader.getStringData("Information",1,0));
        textBoxPage.insertEmail(excelReader.getStringData("Information",1,2));
        textBoxPage.inserCurrentAddress(excelReader.getStringData("Information",1,3));
        textBoxPage.insertPermanentAddress(excelReader.getStringData("Information",1,3));
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.clicOnSubmit();
        Assert.assertTrue(textBoxPage.getInformationField().isDisplayed());
    }
}
