package Test.WidgetsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
    }

    @Test
    public void goToAutoCompletePage() {
        homePage.clickOnCard(homePage.getWidgetsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards", 2, 3));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 8, 0));
        Assert.assertEquals(autoCompletePage.getTitle().getText(), excelReader.getStringData("Cards", 2, 3));
    }

    @Test
    public void userCanEnterMultipleColors() {
        goToAutoCompletePage();
        autoCompletePage.clickOnMulipleAutoCompleteField();
        String color1 = excelReader.getStringData("Colors", 0, 0);
        String color2 = excelReader.getStringData("Colors", 0, 1);
        autoCompletePage.enterColors(color1);
        autoCompletePage.enterColors(color2);
        Assert.assertEquals(autoCompletePage.TextInField(), color1 + color2);
    }

    @Test
    public void userCanEnterSingleColor() {
        goToAutoCompletePage();
        String color = excelReader.getStringData("Colors", 0, 0);
        autoCompletePage.enterSingleColor(color);
        Assert.assertEquals(autoCompletePage.getSingleText().getText(), color);

    }
}

