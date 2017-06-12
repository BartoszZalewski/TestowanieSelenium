package Regon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Regon {
    private final String url = "http://zylla.wipos.p.lodz.pl/ut/js-pesel.html";
    private final String selectName = "numer";
    private final String sectionValue = "1";
    private final String dataId = "dane";
    private final String checkButtonName = "go";
    private final String controlNumberFiledName = "wynik";
    private final String commentFieldName = "uwagi";


    public String controlSumFieldValue(String pesel){
        return getFieldValue(controlNumberFiledName, pesel);
    }

    public String getCommentFieldValue(String pesel){
        return getFieldValue(commentFieldName, pesel);
    }

    private String getFieldValue(String fieldName, String pesel){
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        Select select = new Select(driver.findElement(By.id(selectName)));
        WebElement inputDataField = driver.findElement(By.id(dataId));
        WebElement field = driver.findElement(By.name(fieldName));

        select.selectByValue(sectionValue);
        inputDataField.clear();
        inputDataField.sendKeys(pesel);

        inputDataField.sendKeys(Keys.ENTER);

        String result = field.getAttribute("value");

        driver.close();
        driver.quit();

        return result;
    }
}
