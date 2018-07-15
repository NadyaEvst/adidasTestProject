package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Надежда on 14.07.2018.
 */
public class SamplePage extends AbstractPage {
    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement commentInput;

    @FindBy(xpath = "//input[@id='author']")
    private WebElement authorInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='url']")
    private WebElement websiteInput;

    @FindBy(xpath = "//input[@id='submit' and @type='submit']")
    private WebElement postCommentButton;

    public WebElement getCommentBlockByIndex(int index) {
        return driver.findElement(By.xpath("//ol/li[" + index + "]"));
    }

    public String getCommentAuthorByIndex(int index) {
        return getCommentBlockByIndex(index).findElement(By.xpath(".//div[@class='comment-author vcard']//a")).getText();
    }

    public String getCommentBodyByIndex(int index) {
        return getCommentBlockByIndex(index).findElement(By.xpath(".//div[@class='comment-body']/p")).getText();
    }

    public SamplePage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfCommentsOnThePage() {
        return driver.findElements(By.xpath("//ol/li")).size();
    }

    public void setAuthorName(String name) {
        authorInput.sendKeys(name);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setCommentText(String comment) {
        commentInput.clear();
        commentInput.sendKeys(comment);
    }

    public void setWebsite(String url) {
        websiteInput.sendKeys(url);
    }

    public void addComment(String name, String email, String comment, String url) {
        setAuthorName(name);
        setCommentText(comment);
        setEmail(email);
        setWebsite(url);
        clickPostCommentButton();
    }

    public void clickPostCommentButton() {
        postCommentButton.click();
    }

    public ErrorPage submitCommentWithError(String name, String email, String comment, String url) {
        addComment(name, email, comment, url);
        waitForLoad();
        return new ErrorPage(driver);
    }

    public SamplePage successfulCommentSubmition(String name, String email, String comment, String url) {
        addComment(name, email, comment, url);
        waitForLoad();
        return new SamplePage(driver);
    }
}
