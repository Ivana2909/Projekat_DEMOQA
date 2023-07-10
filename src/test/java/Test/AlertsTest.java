package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority = 10)
    public void goToAlertsPage() {
        homePage.clickOnCard(homePage.getAlerts_frame_windowsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",2,2));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 5, 3));

    }

    @Test(priority = 20)
    public void userCanHandleFirstAlert() throws InterruptedException {
        goToAlertsPage();
        alertsPage.clikcOnAlertButton();
        alertsPage.clickOkButtonOnAlert();
    }

    @Test(priority = 30)
    public void userCanHandleTimeAlert() throws InterruptedException {
        goToAlertsPage();
        alertsPage.clickOnTimeAlertButton();
        Thread.sleep(6000);
        alertsPage.clickOkButtonOnAlert();
    }

    @Test(priority = 40)
    public void userCanConfirmAlert() throws InterruptedException {
        goToAlertsPage();
        alertsPage.clickOnConfirmBoxButton();
        Thread.sleep(1000);
        alertsPage.clickOkButtonOnAlert();
        Assert.assertTrue(alertsPage.getConfirmMessage().isDisplayed());
        Assert.assertEquals(alertsPage.getConfirmMessage().getText(), "You selected Ok");
    }

    @Test(priority = 50)
    public void userCanCancelConfirmBoxAlert() throws InterruptedException {
        goToAlertsPage();
        alertsPage.clickOnConfirmBoxButton();
        Thread.sleep(1000);
        alertsPage.clickCancelButtonOnAlert();
        Assert.assertTrue(alertsPage.getConfirmMessage().isDisplayed());
        Assert.assertEquals(alertsPage.getConfirmMessage().getText(), "You selected Cancel");
    }

    @Test(priority = 60)
    public void userCanConfirmEnteredNameIntoAlert() throws InterruptedException {
        goToAlertsPage();
        alertsPage.clickOnPromptBoxButton();
        String name = excelReader.getStringData("Information", 1, 0);
        alertsPage.enterTextIntoAlert(name);
        alertsPage.clickOkButtonOnAlert();
        Assert.assertTrue(alertsPage.getPomptUpMessage().isDisplayed());
        Assert.assertEquals(alertsPage.getPomptUpMessage().getText(), ("You entered " + name));
    }

    @Test(priority = 70)
    public void userCanCancelEnteredNameIntoAlert() throws Exception {
        goToAlertsPage();
        alertsPage.clickOnPromptBoxButton();
        String name = excelReader.getStringData("Information", 1, 0);
        alertsPage.enterTextIntoAlert(name);
        alertsPage.clickCancelButtonOnAlert();
        Assert.assertFalse(elementIsPresent(alertsPage.getPomptUpMessage()));

    }


}


