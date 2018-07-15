package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Надежда on 14.07.2018.
 */
public class HomePage extends AbstractPage {
    @FindBy(xpath = "//a[@href='http://store.demoqa.com/sample-page/']")
    private WebElement samplePageLink;

    public HomePage(WebDriver driver) {
        super(driver);
        waiter(6);
    }

    public void clickSamplePageLink() {
        samplePageLink.click();
    }

    public SamplePage goToSamplePage() {
        clickSamplePageLink();
        waitForLoad();
        return new SamplePage(driver);
    }
}
