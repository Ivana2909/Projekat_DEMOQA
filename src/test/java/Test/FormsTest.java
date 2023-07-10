package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));

    }

    @Test(priority = 10)
    public void goToPracticeForm() {
         homePage.clickOnCard(homePage.getFormsText());
        sideBarPage.clickOnDropDownofSection(excelReader.getStringData("Cards",1,1));
        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",5,2));

    }

    @Test(priority = 20)
    public void userCanSubmitRegistrationForm() throws InterruptedException {
        goToPracticeForm();
        String firstName = excelReader.getStringData("Information", 1, 0);
        String lastName = excelReader.getStringData("Information", 1, 1);
        String email = excelReader.getStringData("Information", 1, 2);
        practiceFormsPage.insertFirstName(firstName);
        practiceFormsPage.insertLastName(lastName);
        practiceFormsPage.insertEmail(email);
        practiceFormsPage.clickOnGender(excelReader.getStringData("Information",1,7));
        practiceFormsPage.insertMobile("0123456789");
        practiceFormsPage.insertDateOfBirth("29 Sep 1996");
        scrollIntoView(practiceFormsPage.getSubjects());
        practiceFormsPage.insertSubjects(excelReader.getStringData("Information",1,8));
         practiceFormsPage.clickOnHobby(excelReader.getStringData("Information",1,9));
       practiceFormsPage.uploadPicture(excelReader.getStringData("Information",1,6));
        practiceFormsPage.insertCurrentAddress(excelReader.getStringData("Information",1,3));
        sideBarPage.clickOnElement(homePage.getInteractionsText());
        scrollIntoView(practiceFormsPage.getStateDropDown());
        Thread.sleep(3000);
        practiceFormsPage.selectState();
        practiceFormsPage.selectCity();
        sideBarPage.clickOnSection(excelReader.getStringData("Cards",1,3));
        scrollIntoView(practiceFormsPage.getSubmitButton());
        practiceFormsPage.clickSubmit();
        Assert.assertTrue(practiceFormsPage.getMessageForSubmitig().isDisplayed());
        Assert.assertEquals(practiceFormsPage.getMessageForSubmitig().getText(),"Thanks for submitting the form");
        ESCAPE();
        Assert.assertTrue(practiceFormsPage.getSubmitButton().isDisplayed());

    }

}
