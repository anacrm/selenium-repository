import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchToActiveWindow {
    @BeforeClass
    public static void setupClass() {
        //sets the location for the chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void switchToActiveWindow() throws InterruptedException {
        //new instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        // the driver navigate in the page
        driver.get("https://formy-project.herokuapp.com/switch-window");
        Thread.sleep(3000);
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        Thread.sleep(3000);
        newTabButton.click();
        Thread.sleep(3000);

        String originalHandle = driver.getWindowHandle();

        for(String windowHandle: driver.getWindowHandles()){
            Thread.sleep(3000);
            driver.switchTo().window(windowHandle);

            if (! windowHandle.equals(originalHandle)) {
                WebElement newButton = driver.findElement(By.className("btn-lg"));
                newButton.click();
            }

        }
        Thread.sleep(3000);
        driver.switchTo().window(originalHandle);
        Thread.sleep(3000);
        driver.quit();
    }
}
