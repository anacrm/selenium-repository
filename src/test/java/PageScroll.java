import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class PageScroll {

    @BeforeClass
    public static void setupClass() {
        //sets the location for the chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void pageScroll() throws InterruptedException {
        //new instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        // the driver navigate in the page
        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement fullName = driver.findElement(By.id("name"));

        //use Actions class to move to an element
        Actions actions = new Actions(driver);
        actions.moveToElement(fullName);
        fullName.sendKeys("Ana Carolina dos Reis Medeiros");

        Thread.sleep(3000);

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("16/01/91");

        driver.quit();

    }
}
