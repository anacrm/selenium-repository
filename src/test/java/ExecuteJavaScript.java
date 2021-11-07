import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExecuteJavaScript {
    @BeforeClass
    public static void setupClass() {
        //sets the location for the chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void modal() throws InterruptedException {
        //new instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        // the driver navigate in the page
        driver.get("https://formy-project.herokuapp.com/modal");
        Thread.sleep(3000);

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();
        Thread.sleep(3000);

        WebElement closeButton = driver.findElement(By.id("close-button"));

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",closeButton);

        Thread.sleep(3000);

        driver.quit();
    }
}
