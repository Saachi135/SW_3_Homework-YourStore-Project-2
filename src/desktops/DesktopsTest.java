package desktops;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops
        selectMenu("Show AllDesktops");

        WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control' and @id = 'input-sort']"));
        //1.3 Select Sort By position "Name: Z to A
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name (Z - A)");
        // select.selectByValue("https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");

        List<WebElement> productNames = driver.findElements(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(7) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(1) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
        List<String> originalList = new ArrayList<>();
        for (WebElement productName : productNames) {
            originalList.add(productName.getText());
        }
        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList, Collections.reverseOrder());
        Assert.assertEquals(originalList, sortedList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {

        //2.1 Mouse hover on Desktops Tab.and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //2.2 call selectMenu method and pass the menu = “Show All Desktops
        selectMenu("Show AllDesktops");

        WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control' and @id = 'input-sort']"));
        //2.3 Select Sort By position "Name: A to Z
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//img[@title='HP LP3065']"));
        //2.5 Verify the Text "HP LP3065"
        String expectedMessage = "HP LP3065";
        String actualMessage = getTextFromElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);

        //2.6 Select Delivery Date "2022-11-30"
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
        WebElement date = driver.findElement(By.cssSelector("#input-option225"));
        date.sendKeys("2022-11-30");

        //2.7.Enter Qty 1 using Select class.
        // sendKeyElement(By.xpath("//input[@id='input-quantity']"),"1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2.10 Click on link “shopping cart” display into success message
        WebElement desktopsTab = driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        desktopsTab.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2.11 Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart  (1.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.linkText("HP LP3065")));

        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertEquals("Delivery Date:2022-11-30", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']")));

        //2.14 Verify the Model "Product21"
        Assert.assertEquals("Product 21", getTextFromElement(By.xpath("//td[normalize-space()='Product 21']")));

        //2.15 Verify the Total "$122.00"
        //mouseHoverAndClick(By.xpath("//i[@class='fa fa-caret-down']"));
        Assert.assertEquals("$122.00", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));

    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
