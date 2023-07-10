package Test.ElementsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority = 10)
    public void goToRadioButtonPage() {
        homePage.clickOnCard(homePage.getElementsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards", 3, 0));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 5, 6));
    }

    @Test(priority = 20)
    public void clickOnRadioButtonYes() {
        goToRadioButtonPage();
        radioButtonPage.clickOnRadioButton("Yes");
        Assert.assertTrue(radioButtonPage.getMessageSuccess().isDisplayed());
        Assert.assertEquals(radioButtonPage.getMessageSuccess().getText(), "Yes");

    }

    @Test(priority = 30)
    public void clickOnRadioButtonImpressive() {
        goToRadioButtonPage();
        radioButtonPage.clickOnRadioButton("Impressive");
        Assert.assertTrue(radioButtonPage.getMessageSuccess().isDisplayed());
        Assert.assertEquals(radioButtonPage.getMessageSuccess().getText(), "Impressive");

    }

    @Test(priority = 40)
    public void clickOnRadioButtonNo() {
        goToRadioButtonPage();
        radioButtonPage.clickOnRadioButton("No");
        Assert.assertTrue(radioButtonPage.getMessageSuccess().isDisplayed());
        Assert.assertEquals(radioButtonPage.getMessageSuccess().getText(), "No");

    }



}
