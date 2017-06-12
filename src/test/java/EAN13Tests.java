import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class EAN13Tests {
    private final String correctControlSum = "Dobry";
    private final String incorrectControlSum = "Błędny";
    private final String notEnoughDigits = "zbyt mało cyfr";
    private final String tooManyDigits = "za dużo cyfr";
    private NumberVerifierSiteHelper numberVerifierSiteHelper = new NumberVerifierSiteHelper(Select.EAN13.value());

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleEan13Test(){
        String ean8Value = "4007630000116";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumLowerTest(){
        String ean8Value = "0000000000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumUpperTest(){
        String ean8Value = "9999999999994";

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
        String ean8Value = "999999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void tooManyDigitsLowerTest() {
        String ean8Value = "10000000000000";

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
        String ean8Value = "XXXXXXXXXXXXX";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectPrefixLowerTest() {
        String ean8Value = "0000000000001";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectPrefixUpperTest() {
        String ean8Value = "9999999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void correctControlSumButIncorrectPrefixLowerTest() {
        String ean8Value = "1400000000007";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumButIncorrectPrefixUpperTest() {
        String ean8Value = "9899999999997";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void incorrectControlSumAndIncorrectPrefixLowerTest() {
        String ean8Value = "1400000000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumAndIncorrectPrefixUpperTest() {
        String ean8Value = "9899999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(ean8Value);

        assert resultControlSum.contains(incorrectControlSum);
    }
}
