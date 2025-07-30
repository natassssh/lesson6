package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    @FindBy(css = "#bug_arr_all")
    private WebElement tableFooter;

    @FindBy(xpath = "//*[@id='buglist']//tr[1]/td[11]")
    private WebElement lastIssueSummary;

    @FindBy(xpath = "//select/option[contains(text(), 'Delete')]")
    private WebElement deleteOption;

    @FindBy(xpath = "//label")
    private WebElement checkbox1;

    @FindBy(xpath = "//*[@value='OK']")
    private WebElement OkButton;

    @FindBy(xpath = "//*[@id='buglist']//tr[1]/td[4]/a")
    private WebElement firstId;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30),  Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public int countIssues() {
        return issues.size();
    }

    public String getLastIssueSummary() {
        return lastIssueSummary.getText();
    }

    public void deleteLastIssue() {
        checkbox1.click();
        deleteOption.click();
        OkButton.click();
    }

    public String getFirstId() {
        return firstId.getText();
    }
}
