package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ErrorPage;
import pages.SamplePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Nadya on 14.07.2018.
 */
public class AddCommentTest extends AbstractTest {
    @DataProvider(name = "comment samples")
    public static Object[][] commentSamples() {
        return new Object[][]{{"Zabka", "123", "qwe@qwe.com", "test comment ", "", "ERROR: please enter a valid email address."},
                {"Monkey", "asd@asd", "123@sdf.ru", "test comment ", "", "ERROR: please enter a valid email address."}};
    }

    @Test(description = "Checking error appeares after enter wrong email address", dataProvider = "comment samples")
    public void AddCommentTest(String name, String badEmail, String goodEmail, String comment, String url, String errMsg) {
        comment = comment + Math.random(); //Cool, there is functionality for checking duplicated comments, but I don't wanna test it now
        SamplePage samplePage = homePage.goToSamplePage();
        ErrorPage errorPage = samplePage.submitCommentWithError(name, badEmail, comment, url);
        assertThat("Errormessage has appeared", errorPage.getErrorMsg(), equalTo(errMsg));
        samplePage = errorPage.goToSamplePage();
        assertThat("New comment wasn't added.", samplePage.getAmountOfCommentsOnThePage(), equalTo(0));
        samplePage = samplePage.successfulCommentSubmition(name, goodEmail, comment, url);
        int numberOfCommentsOnThePage = samplePage.getAmountOfCommentsOnThePage();
        assertThat("Last added comment author is correct.", samplePage.getCommentAuthorByIndex(numberOfCommentsOnThePage), equalTo(name));
        assertThat("Last addded comment body is correct.", samplePage.getCommentBodyByIndex(numberOfCommentsOnThePage), equalTo(comment));
    }


}
