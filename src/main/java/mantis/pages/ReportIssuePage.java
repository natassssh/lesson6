package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id='summary']")
    private WebElement summaryField;

    @FindBy(xpath = "//*[@id='description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;


    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30),  Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public void fillDataIssue(String summary, String description) {
        summaryField.sendKeys(summary);
        descriptionField.sendKeys(description);
        submitButton.click();
    }
}
