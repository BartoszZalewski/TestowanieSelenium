package Pesel;

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

    @Before
    public void setUpProperty() throws IOException {
        File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver.exe");
        //File chromeDriverFile = new File("../TestowanieSelenium/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver",chromeDriverFile.getCanonicalPath());
    }

    @Test
    public void sampleValidTest(){
        String peselValue = "94112306312";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert !comments.contains(incorrectDate);
    }

    @Test
    public void correctControlSumLowerTest(){
        String peselValue = "97810100079";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumTest(){
        String peselValue = "17260799991";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void correctControlSumUpperTest(){
        String peselValue = "95113024133";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
    }

    @Test
    public void notEnoughDigitsLowerTest(){
        String peselValue = "0";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void notEnoughDigitsUpperTest(){
        String peselValue = "9999999999";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(notEnoughDigits);
    }

    @Test
    public void tooManyDigitsLowerTest(){
        String peselValue = "100000000000";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void tooManyDigitsHighTest(){
        String peselValue = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(tooManyDigits);
    }

    @Test
    public void incorrectDayMonthAndControlSumLowerTest() {
        String peselValue = "00000000001";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }


    @Test
    public void incorrectDayMonthAndControlSumUpperTest() {
        String peselValue = "99939999999";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void incorrectDayMonthLowerTest() {
        String peselValue = "00000000000";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void incorrectDayMonthUpperTest() {
        String peselValue = "99939999992";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthLowerTest() {
        String peselValue = "00010000000";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthUpperTest() {
        String peselValue = "99929999999";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayLowerTest() {
        String peselValue = "00000100000";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayUpperTest() {
        String peselValue = "99993199999";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndControlSumLowerTest() {
        String peselValue = "00000100003";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndControlSumUpperTest() {
        String peselValue = "99993199996";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthAndControlSumLowerTest() {
        String peselValue = "00010000009";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectMonthAndControlSumUpperTest() {
        String peselValue = "99929999993";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(correctControlSum);
        assert comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndMonthLowerTest() {
        String peselValue = "00010100001";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert !comments.contains(incorrectDate);
    }

    @Test
    public void onlyCorrectDayAndMonthUpperTest() {
        String peselValue = "99923199999";

        Pesel pesel = new Pesel();

        String resultControlSum = pesel.controlSumFieldValue(peselValue);
        String comments = pesel.getCommentFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
        assert !comments.contains(incorrectDate);
    }

    @Test
    public void notNumericalValueTest(){
        String peselValue = "XXXXXXXXXXX";

        String resultControlSum = new Pesel().controlSumFieldValue(peselValue);

        assert resultControlSum.contains(incorrectControlSum);
    }

}
