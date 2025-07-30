package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mantis.pages.MantisSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }

    }
}
