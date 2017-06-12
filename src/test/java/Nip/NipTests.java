package Nip;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class NipTests {
    private final String correctControlSum = "Dobry";
    private final String incorrectControlSum = "Błędny";
    private final String notEnoughDigits = "zbyt mało cyfr";
    private final String tooManyDigits = "za dużo cyfr";
    private final String incorrectTaxOfficeId = "błędny kod Urzędu";

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleRegonTest(){
        String nipValue = "1234563218";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumLowerTest(){
        String nipValue = "1010000000";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumUpperTest(){
        String nipValue = "9989999992";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void notEnoughDigitsLowerTest() {
        String nipValue = "0";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void notEnoughDigitsUpperTest() {
        String nipValue = "999999999";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void tooManyDigitsLowerTest() {
        String nipValue = "10000000000";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void tooManyDigitsUpperTest() {
        String nipValue = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void incorrectNumericalValue() {
        String nipValue = "XXXXXXXXXX";

        Nip nip = new Nip();

        String resultControlSum = nip.controlSumFieldValue(nipValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectTaxOfficeIdLowerTest() {
        String nipValue = "1010000001";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectTaxOfficeIdUpperTest() {
        String nipValue = "9989999999";

        String resultControlSum = new Nip().controlSumFieldValue(nipValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void correctControlSumButIncorrectTaxOfficeIdLowerTest() {
        String nipValue = "0000000000";

        Nip nip = new Nip();

        String resultControlSum = nip.controlSumFieldValue(nipValue);
        String comments = nip.getCommentFieldValue(nipValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectTaxOfficeId);
    }

    @Test
    public void correctControlSumButIncorrectTaxOfficeIdUpperTest() {
        String nipValue = "9999999999";

        Nip nip = new Nip();

        String resultControlSum = nip.controlSumFieldValue(nipValue);
        String comments = nip.getCommentFieldValue(nipValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectTaxOfficeId);
    }

    @Test
    public void incorrectControlSumAndTaxOfficeIdLowerTest() {
        String nipValue = "0000000001";

        Nip nip = new Nip();

        String resultControlSum = nip.controlSumFieldValue(nipValue);
        String comments = nip.getCommentFieldValue(nipValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectTaxOfficeId);
    }

    @Test
    public void incorrectControlSumAndTaxOfficeIdUpperTest() {
        String nipValue = "9999999998";

        Nip nip = new Nip();

        String resultControlSum = nip.controlSumFieldValue(nipValue);
        String comments = nip.getCommentFieldValue(nipValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectTaxOfficeId);
    }
}
