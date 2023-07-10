package Test.WidgetsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority = 10)
    public void goToProgressBarPage() {
        homePage.clickOnCard(homePage.getWidgetsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",5,3));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 5, 4));

    }

    @Test(priority = 20)
    public void userCanStartLoading() throws InterruptedException {
        goToProgressBarPage();
        progressBarPage.clickOnButtonForStartOrStopProgressBar();
        Assert.assertEquals(progressBarPage.getButton().getText(), "Stop");
    }
    @Test(priority = 30)
    public void userCanStopLoading() throws InterruptedException {
        goToProgressBarPage();
        progressBarPage.clickOnButtonForStartOrStopProgressBar();
        Assert.assertEquals(progressBarPage.getButton().getText(), "Stop");

        //waitForVisibility(progressBarPage.getResetButton());
        progressBarPage.clickOnButtonForStartOrStopProgressBar();
        Assert.assertEquals(progressBarPage.getButton().getText(), "Start");
    }

        @Test(priority = 40)
        public void userCanFinishLoading() throws InterruptedException {
            goToProgressBarPage();
            progressBarPage.clickOnButtonForStartOrStopProgressBar();
            progressBarPage.waitForFinish();
    }
}
