package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops
        selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals("Desktops", getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']")));

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        selectMenu("Show AllLaptops & Notebooks");

        Assert.assertEquals("Laptops & Notebooks", getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        mouseHoverAndClick(By.xpath("//a[normalize-space()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals("Components", getTextFromElement(By.xpath("//h2[normalize-space()='Components']")));


    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
