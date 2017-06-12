import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NumberVerifierSiteHelper {
    private final String url = "http://zylla.wipos.p.lodz.pl/ut/js-pesel.html";
    private final String selectName = "numer";
    private final String dataId = "dane";
    private final String checkButtonName = "go";
    private final String controlNumberFiledName = "wynik";
    private final String commentFieldName = "uwagi";

    private String sectionValue = "2";

    public NumberVerifierSiteHelper(String sectionValue) {
        this.sectionValue = sectionValue;
    }

    public String controlSumFieldValue(String key){
        return getFieldValue(controlNumberFiledName, key);
    }

    public String getCommentFieldValue(String key){
        return getFieldValue(commentFieldName, key);
    }

    private String getFieldValue(String fieldName, String key){
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        Select select = new Select(driver.findElement(By.id(selectName)));
        WebElement inputDataField = driver.findElement(By.id(dataId));
        WebElement field = driver.findElement(By.name(fieldName));

        select.selectByValue(sectionValue);
        inputDataField.clear();
        inputDataField.sendKeys(key);

        inputDataField.sendKeys(Keys.ENTER);

        String result = field.getAttribute("value");

        driver.close();
        driver.quit();

        return result;
    }
}
