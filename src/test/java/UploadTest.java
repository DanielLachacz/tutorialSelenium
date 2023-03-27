import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void executeJavaScript() throws IOException {
        ChromeOptions options = new ChromeOptions();     //Obejście błędu Selenium
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        int randomNumber = (int) (Math.random()*1000);
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(before,new File("src/test/resources/screenshot.png"));
        String fileName = "beforeUpload" + randomNumber + ".png";
        FileUtils.copyFile(before,new File("src/test/resources/" + fileName));
        driver.findElement(By.id("myFile")).sendKeys("/Users/daniellachacz/Desktop/nowy.txt");

        Actions actions = new Actions(driver);
        actions.contextClick().perform();

    }
}
