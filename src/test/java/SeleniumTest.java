import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
// klikniecie przycisku
        agreeButton.click();
        // znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wprowadz wartosc Selenium do pola
        searchField.sendKeys("Selenium");
        // zasymuluj nacisniecie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        // znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                String chromePath = "/Users/daniellachacz/Downloads/chromedriver_mac64-2/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();
            case "chrome2":
                String chromePath2 = "/Users/daniellachacz/Downloads/chromedriver_mac64-2/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromePath2);
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }



}
