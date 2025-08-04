package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewIssuesTests extends BaseTest {

    private MantisSite mantisSite;

    @Test
    public void checkIssuesNumber() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuesPage();

        int actualIssuesNumber = mantisSite.getViewIssuePage().countIssues();

        Assertions.assertEquals(50, actualIssuesNumber);
    }

    @Test
    public void createDeleteIssue() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        mantisSite.getReportIssuePage().fillDataIssue(timeStamp, timeStamp);

        String id = mantisSite.getViewIssuePage().getFirstId();

        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(timeStamp).isEqualTo(mantisSite.getViewIssuePage().getLastIssueSummary());
        softAssert.assertThat(id).isEqualTo(mantisSite.getViewIssuePage().getFirstId());

        mantisSite.getViewIssuePage().deleteLastIssue();
        mantisSite.getDeletionConfirmationPage().sureToDelete();

        softAssert.assertThat(mantisSite.getViewIssuePage().getFirstId()).isNotEqualTo(id);
        softAssert.assertAll();
    }

}
