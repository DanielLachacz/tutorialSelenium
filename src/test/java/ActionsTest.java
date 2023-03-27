import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    @Test
    public void actionsTest() throws IOException {
        ChromeOptions options = new ChromeOptions();     //Obejście błędu Selenium
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        Actions actions = new Actions(driver);
        actions.contextClick().perform();
       // actions.contextClick(driver.findElement(By.id("myFile"))).perform(); //one click

        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform();                       //double click

    }
}
