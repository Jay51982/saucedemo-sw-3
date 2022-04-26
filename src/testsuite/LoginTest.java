package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
    public void userSholdLoginSuccessfullyWithValid(){
        //find Username field and insert value

    getTextFromElement(By.id("user-name"));
    sendTextToElement(By.id("user-name"),"\"standard_user\"");

        //find password field and insert value

    getTextFromElement(By.id("password"));
    sendTextToElement(By.id("password"),"secret_sauce");

        //find login button and click it

    clickOnElement(By.xpath("//input[@class='submit-button btn_action']"));

        //Verify the text “PRODUCTS”

        String secureArea = getTextFromElement(By.className("title"));
        Assert.assertEquals("Incorrect Login detail", "PRODUCTS", secureArea);
    }

    @Test
public void verifyThatSixProductsAreDisplayedOnPage() {

        getTextFromElement(By.id("user-name"));
        sendTextToElement(By.id("user-name"),"standard_user");


        getTextFromElement(By.id("password"));
        sendTextToElement(By.id("password"),"secret_sauce");

        //find login button and click it

        clickOnElement(By.xpath("//input[@class='submit-button btn_action']"));

        //* Verify that six products are displayed on page
        List<WebElement> verifydisplaylist = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']\n"));
        System.out.println("Item display  : "  +  verifydisplaylist.size());

        int expectedImages = 6;

        Assert.assertEquals("All Six products displayed on screen.",expectedImages,verifydisplaylist.size());
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
