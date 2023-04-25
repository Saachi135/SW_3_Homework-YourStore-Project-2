package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        // assigned chrome driver
        driver = new ChromeDriver();
        // set base url
        driver.get(baseUrl);
        // window maximize
        driver.manage().window().maximize();
        // implicit waiting
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    public void closeBrowser() {
        driver.quit();

    }

}

