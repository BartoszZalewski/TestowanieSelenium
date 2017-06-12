import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class EAN8Tests {
    private final String correctControlSum = "Dobry";
    private final String incorrectControlSum = "Błędny";
    private final String notEnoughDigits = "zbyt mało cyfr";
    private final String tooManyDigits = "za dużo cyfr";
    private NumberVerifierSiteHelper numberVerifierSiteHelper = new NumberVerifierSiteHelper(Select.EAN8.value());

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleEan8Test(){
        String ean8Value = "59012344";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumLowerTest(){
        String ean8Value = "00000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumUpperTest(){
        String ean8Value = "99999995";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void notEnoughDigitsLowerTest() {
        String ean8Value = "0";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void notEnoughDigitsUpperTest() {
        String ean8Value = "9999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void tooManyDigitsLowerTest() {
        String ean8Value = "100000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void tooManyDigitsUpperTest() {
        String ean8Value = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void incorrectNumericalValue() {
        String ean8Value = "XXXXXXXX";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectPrefixLowerTest() {
        String ean8Value = "00000001";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectPrefixUpperTest() {
        String ean8Value = "99999991";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void correctControlSumButIncorrectPrefixLowerTest() {
        String ean8Value = "14000003";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumButIncorrectPrefixUpperTest() {
        String ean8Value = "98999996";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void incorrectControlSumAndIncorrectPrefixLowerTest() {
        String ean8Value = "14000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumAndIncorrectPrefixUpperTest() {
        String ean8Value = "98999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }


}
