import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;

public class PeselTests {

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../Testowanie/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../Testowanie/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void samplePeselTest(){
        String url = "http://zylla.wipos.p.lodz.pl/ut/js-pesel.html";
        String selectName = "numer";
        String sectionValue = "0";
        String dataId = "dane";
        String resultFiledName = "wynik";
        String validPesel = "94112306312";
        String testResultValue = "Dobry";

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        Select select = new Select(driver.findElement(By.id(selectName)));
        WebElement inputDataField = driver.findElement(By.id(dataId));
        WebElement resultControlSumField = driver.findElement(By.name(resultFiledName));

        select.selectByValue(sectionValue);
        inputDataField.clear();
        inputDataField.sendKeys(validPesel);
        inputDataField.sendKeys(Keys.ENTER);

        String result = resultControlSumField.getText();
        assert !result.contains(testResultValue);

        driver.close();
        driver.quit();
    }


}
