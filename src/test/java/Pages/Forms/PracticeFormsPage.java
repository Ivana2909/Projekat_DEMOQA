package Pages.Forms;

import Base.BaseTest;
import org.openqa.selenium.*;

import java.util.List;

public class PracticeFormsPage extends BaseTest {
    WebDriver driver;
    WebElement firstName;
    WebElement lastName;
    WebElement email;
    List<WebElement> genderRadioButton;
    WebElement mobile;
    WebElement dateOfBirth;
    WebElement subjects;
    WebElement sportCheck;
    WebElement readingCheck;
    WebElement musicCheck;
    WebElement currentAddress;
    WebElement uploadPicture;
    WebElement stateDropDown;
    WebElement cityDropDown;
    WebElement submitButton;
    WebElement closeButton;
    WebElement messageForSubmitig;

    public PracticeFormsPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public List<WebElement> getGenderRadioButton() {
        return driver.findElements(By.cssSelector(".custom-control.custom-radio.custom-control-inline"));
    }

    public WebElement getMobile() {
        return driver.findElement(By.id("userNumber"));
    }

    public WebElement getDateOfBirth() {
        return driver.findElement(By.id("dateOfBirthInput"));
    }

    public WebElement getSubjects() {
        return driver.findElement(By.id("subjectsInput"));
    }

    public WebElement getSportCheck() {
        return driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
    }

    public WebElement getReadingCheck() {
        return driver.findElement(By.id("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"));
    }

    public WebElement getMusicCheck() {
        return driver.findElement(By.id("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getUploadPicture() {
        return driver.findElement(By.id("uploadPicture"));
    }

    public WebElement getStateDropDown() {
        return driver.findElement(By.id("state"));
    }

    public WebElement getCityDropDown() {
        return driver.findElement(By.id("city"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getCloseButton() {
        //return driver.findElement(By.id("closeLargeModal"));
        return driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]"));

    }

    public WebElement getMessageForSubmitig() {
        return driver.findElement(By.id("example-modal-sizes-title-lg"));
    }

    //---------------------------------------------------

    public void insertFirstName(String firstName) {
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        getLastName().clear();
        getLastName().sendKeys(lastName);
    }

    public void insertEmail(String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void clickOnGender(String gender) {
        for (int i = 0; i < getGenderRadioButton().size(); i++) {
            if (gender.equals("male")) {
                getGenderRadioButton().get(0).click();
                break;
            } else if (gender.equals("female")) {
                getGenderRadioButton().get(1).click();
                break;
            } else {
                getGenderRadioButton().get(2).click();
                break;
            }
        }

    }

    public void insertMobile(String mobile) {
        getMobile().clear();
        getMobile().sendKeys(mobile);
    }

    public void insertDateOfBirth(String date) {
        selectAll(getDateOfBirth());
        getDateOfBirth().sendKeys(date);
        getDateOfBirth().sendKeys(Keys.ESCAPE);
    }

    public void insertSubjects(String subjects) {
        getSubjects().click();
        getSubjects().clear();
        getSubjects().sendKeys(subjects);
        getSubjects().sendKeys(Keys.ENTER);

    }

    public void clickOnHobby(String hobby) {
        if (hobby.equalsIgnoreCase("sports")) {
            getSportCheck().click();
        } else if (hobby.equalsIgnoreCase("reading")) {
            getReadingCheck().click();
        } else if (hobby.equalsIgnoreCase("music")) {
            getMusicCheck().click();
        }
    }

    public void uploadPicture(String location) {
        getUploadPicture().sendKeys(location);

    }

    public void insertCurrentAddress(String address) {
        getCurrentAddress().clear();
        getCurrentAddress().sendKeys(address);
    }

    public void selectState() {
        getStateDropDown().click();
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

    }

    public void selectCity() {
        getCityDropDown().click();
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    public void clickSubmit() {
        getSubmitButton().click();
    }

    public void clickClose() {
        getCloseButton().click();
    }

}
