import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SwitchToAlert {

    @BeforeClass
    public static void setupClass() {
        //sets the location for the chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void switchWindow() throws InterruptedException {
        //new instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        // the driver navigate in the page
        driver.get("https://formy-project.herokuapp.com/switch-window");
        Thread.sleep(3000);

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(3000);
        driver.quit();
    }

}
