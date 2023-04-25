package Utilities;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Utility extends BaseTest {
    public void selectMenu(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().perform();

    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void mouseHoverAndClick(By by) {
        WebElement desktopsTab = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(desktopsTab).click().perform();
    }
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void sendText(By by,int number){
        driver.findElement(by).sendKeys();
    }
    public void sendKeyElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public WebElement findElementFromWebPage(By by) {
        return driver.findElement(by);
    }
    public List<WebElement> findElementsFromWebPage(By by) {
        return driver.findElements(by);
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public void waitTime(int a) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
    }

}

