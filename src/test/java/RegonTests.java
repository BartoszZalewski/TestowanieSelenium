import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class RegonTests {
    private final String correctControlSum = "Dobry";
    private final String incorrectControlSum = "Błędny";
    private final String notEnoughDigits = "zbyt mało cyfr";
    private final String tooManyDigits = "za dużo cyfr";
    private final String incorrectStateNumber = "błędny kod województwa";
    private NumberVerifierSiteHelper numberVerifierSiteHelper = new NumberVerifierSiteHelper(Select.REGON.value());

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleRegonTest(){
        String regonValue = "732065814";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumLowerTest(){
        String regonValue = "000000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumUpperTest(){
        String regonValue = "369999992";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void notEnoughDigitsLowerTest() {
        String regonValue = "0";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void notEnoughDigitsUpperTest() {
        String regonValue = "99999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void tooManyDigitsLowerTest() {
        String regonValue = "1000000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void tooManyDigitsUpperTest() {
        String regonValue = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void incorrectNumericalValue() {
        String regonValue = "XXXXXXXXX";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(regonValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectStateNumber);
    }

    @Test
    public void incorrectControlSumButCorrectStateNumberLowerTest() {
        String regonValue = "000000001";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void incorrectControlSumButCorrectStateNumberUpperTest() {
        String regonValue = "369999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

    @Test
    public void correctControlSumButIncorrectStateNumberLowerTest() {
        String regonValue = "380000008";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(regonValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectStateNumber);
    }

    @Test
    public void correctControlSumButIncorrectStateNumberUpperTest() {
        String regonValue = "999999990";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(regonValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(regonValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectStateNumber);
    }
}
