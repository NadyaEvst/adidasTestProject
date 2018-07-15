package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    protected WebDriver driver;
    final String BASE_URL = "http://store.demoqa.com/";
    HomePage homePage;

    @BeforeMethod
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        homePage.waitForLoad();

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
