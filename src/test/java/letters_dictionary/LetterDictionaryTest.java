package letters_dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class LetterDictionaryTest {

    @Test
    public void shouldReturnEmptyResultWhenGivenStringIsNullOrEmpty() {
        LettersMap lettersMap1 = new LetterDictionary().indexLettersPerWords("");
        LettersMap lettersMap2 = new LetterDictionary().indexLettersPerWords(null);

        assertTrue(lettersMap1.isEmpty());
        assertTrue(lettersMap2.isEmpty());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenStringIsOneLetter() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("A");

        assertEquals("A: A", lettersMap.getResultString());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenStringContainsOnlyOneTypeOfLetter() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("AAAAAAA");

        assertEquals("A: AAAAAAA", lettersMap.getResultString());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenStringContainsTwoWordsWithOnlyOneTypeOfLetter() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("AAAAAAA AAAAAAA");

        assertEquals("A: AAAAAAA", lettersMap.getResultString());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenStringContainsTwoWordsDividedByMultipleSpacesWithOnlyOneTypeOfLetter() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("AAAAAAA        AAAAAAA");

        assertEquals("A: AAAAAAA", lettersMap.getResultString());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenStringContainsTwoWordsDividedByCommaAndSpaceWithOnlyOneTypeOfLetter() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("AAAAAAA, AAAAAAA");

        assertEquals("A: AAAAAAA", lettersMap.getResultString());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenStringContainsTwoWordsWithOnlyOneTypeOfLetterInLowerAndUpperCase() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("AAAAAAA aaaaaaa");

        assertEquals("A: AAAAAAA", lettersMap.getResultString());
    }

    @Test
    public void shouldReturnEachLetterOnlyOncePerWord() {
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords("ala ma kota, kot koduje w Javie kota");

        assertEquals(
                "A: ala, ma, kota, Javie\n" +
                        "D: koduje\n" +
                        "E: koduje, Javie\n" +
                        "I: Javie\n" +
                        "J: koduje, Javie\n" +
                        "K: kota, kot, koduje\n" +
                        "L: ala\n" +
                        "M: ma\n" +
                        "O: kota, kot, koduje\n" +
                        "T: kota, kot\n" +
                        "U: koduje\n" +
                        "V: Javie\n" +
                        "W: w",
                lettersMap.getResultString());
    }

    @Test
    public void TenThousandLoremIpsumPerformanceTest() throws IOException, URISyntaxException {
        performanceTestFor("10KloremIpsum.txt");
    }

    @Test
    public void OneMillionLoremIpsumPerformanceTest() throws IOException, URISyntaxException {
        performanceTestFor("1MloremIpsum.txt");
    }

    @Test
    public void AllDistinctEnglishWordsPerformanceTest() throws IOException, URISyntaxException {
        //https://github.com/dwyl/english-words
        performanceTestFor("allEnglishWords.txt");
    }

    private void performanceTestFor(String s) throws IOException, URISyntaxException {
        String input = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(s).toURI())), Charset.forName("UTF-8"));
        long start = System.currentTimeMillis();
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords(input);
//        System.out.println(lettersMap.getResultString()); //uncomment to see test results
        long end = System.currentTimeMillis() - start;
        System.out.println("Performance test took: " + end + " miliseconds");
    }
}