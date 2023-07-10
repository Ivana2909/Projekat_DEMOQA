package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownloadPage {
    WebDriver driver;
    WebElement downloadButton;
    WebElement uploadButton;
    WebElement filePath;

    public UploadAndDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDownloadButton() {
        return driver.findElement(By.id("downloadButton"));
    }

    public WebElement getUploadButton() {
        return driver.findElement(By.id("uploadFile"));
    }

    public WebElement getFilePath() {
        return driver.findElement(By.id("uploadedFilePath"));
    }

    //-----------------------------------------
    public void clickOnDownload(){
        getDownloadButton().click();
    }
    public void uploadFile(String location){
        getUploadButton().sendKeys(location);
    }
}
