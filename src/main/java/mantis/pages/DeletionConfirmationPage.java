package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeletionConfirmationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@value = 'Delete Issues']")
    private WebElement deleteIssueButton;

    public DeletionConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30),  Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public void sureToDelete() {
        deleteIssueButton.click();
    }
}
