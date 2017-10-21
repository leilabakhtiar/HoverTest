package hoverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by leila on 10/21/2017.
 */
public class HoverTest {

    private WebDriver driver=null;

    private static int BROWSER=2;

    @BeforeTest
    public void intBrowser() {

        if(BROWSER==1) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\leila\\Desktop\\Firefox\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            driver = new ChromeDriver(options);
        }
        else if (BROWSER==2)
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\leila\\Desktop\\Firefox\\geckodriver.exe");
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
            desiredCapabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
        }


    }

    @AfterTest
    public void testTeardown() {
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {

        driver.get("http://www.bamilo.com/");

        Thread.sleep(15000);

        WebElement closeButton= driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/i"));

        closeButton.click();
        Thread.sleep(15000);

        WebElement hOverElement=driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/nav/ul/li[1]/a"));


        Actions builder1 = new Actions(driver);
        builder1.moveToElement(hOverElement).perform();
        Thread.sleep(15000);
        WebElement bagAndShoe=driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/nav/ul/li[1]/div/ul/li[3]/a"));

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(bagAndShoe).click().perform();

        Thread.sleep(15000);
        WebElement sandalShoue=driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/nav/ul/li[1]/div/ul/li[3]/div/div/div[2]/ul/li[4]/a"));
        sandalShoue.click();
        Thread.sleep(15000);
    }



}
