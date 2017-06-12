import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class SampleTest {

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../Testowanie/src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleChromeTest(){
        String url = "http://www.google.com";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.close();
        driver.quit();
    }

    @Test
    public void sampleChromeFindTextTest(){
        String url = "http://www.google.com";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement findField = driver.findElement(By.name("q"));

        findField.clear();
        findField.sendKeys("Selenium java tests examples");
        findField.sendKeys(Keys.ENTER);

        driver.close();
        driver.quit();
    }

}
