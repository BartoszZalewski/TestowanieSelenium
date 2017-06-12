import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class PeselTests {
    private final String correctControlSum = "Dobry";
    private final String incorrectControlSum = "Błędny";
    private final String notEnoughDigits = "zbyt mało cyfr";
    private final String tooManyDigits = "za dużo cyfr";
    private final String incorrectDate = "błędna data";
    private NumberVerifierSiteHelper numberVerifierSiteHelper = new NumberVerifierSiteHelper(Select.PESEL.value());

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleValidTest(){
        String peselValue = "94112306312";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert !comments.contains(incorrectDate);
    }

    @Test
    public void correctControlSumLowerTest(){
        String peselValue = "97810100071";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumTest(){
        String peselValue = "17260799999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumUpperTest(){
        String peselValue = "95113024137";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void notEnoughDigitsLowerTest(){
        String peselValue = "0";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void notEnoughDigitsUpperTest(){
        String peselValue = "9999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void tooManyDigitsLowerTest(){
        String peselValue = "100000000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void tooManyDigitsHighTest(){
        String peselValue = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void incorrectDayMonthAndControlSumLowerTest() {
        String peselValue = "00000000001";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }


    @Test
    public void incorrectDayMonthAndControlSumUpperTest() {
        String peselValue = "99939999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void incorrectDayMonthLowerTest() {
        String peselValue = "00000000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void incorrectDayMonthUpperTest() {
        String peselValue = "99939999998";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthLowerTest() {
        String peselValue = "00010000000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthUpperTest() {
        String peselValue = "99929999999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayLowerTest() {
        String peselValue = "00000100000";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayUpperTest() {
        String peselValue = "99993199999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndControlSumLowerTest() {
        String peselValue = "00000100007";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndControlSumUpperTest() {
        String peselValue = "99993199994";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthAndControlSumLowerTest() {
        String peselValue = "00010000001";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthAndControlSumUpperTest() {
        String peselValue = "99929999997";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndMonthLowerTest() {
        String peselValue = "00010100001";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert !comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndMonthUpperTest() {
        String peselValue = "99923199999";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);
        String comments = numberVerifierSiteHelper.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert !comments.contains(incorrectDate);
    }

    @Test
    public void notNumericalValueTest(){
        String peselValue = "XXXXXXXXXXX";

        String resultControlSum = numberVerifierSiteHelper.controlSumFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

}
