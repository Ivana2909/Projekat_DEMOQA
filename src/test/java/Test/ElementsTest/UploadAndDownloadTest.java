package Test.ElementsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAndDownloadTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority = 10)
    public void goToUploadAndDownloadPage(){
        homePage.clickOnCard(homePage.getElementsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",8,0));
        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",5,5));
    }

    @Test(priority = 20)
    public void download() {
        goToUploadAndDownloadPage();
        uploadAndDownloadPage.clickOnDownload();
        //Assertacija za path fajl
    }
    @Test(priority = 30)
    public void uploadFile(){
        String location=excelReader.getStringData("Information",1,6);
        goToUploadAndDownloadPage();
        uploadAndDownloadPage.uploadFile(location);
        Assert.assertTrue(uploadAndDownloadPage.getFilePath().isDisplayed());
    }
}
