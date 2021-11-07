import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    @BeforeClass
    public static void setupClass() {
        //sets the location for the chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        //new instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        // the driver navigate in the page
        driver.get("https://formy-project.herokuapp.com/dragdrop");

        Thread.sleep(3000);

        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image,box).build().perform();
        Thread.sleep(3000);
        driver.quit();
    }

}

