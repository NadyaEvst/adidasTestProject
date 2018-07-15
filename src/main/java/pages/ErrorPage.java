package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Nadya on 14.07.2018.
 */
public class ErrorPage extends AbstractPage {
    @FindBy(xpath = "//p[strong[contains(text(),'ERROR')]]")
    private WebElement errorMsg;

    @FindBy(xpath = "//a[contains(@href,'back')]")
    private WebElement backLink;

    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    public void clickBackLink() {
        backLink.click();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public SamplePage goToSamplePage() {
        clickBackLink();
        waitForLoad();
        return new SamplePage(driver);
    }
}
