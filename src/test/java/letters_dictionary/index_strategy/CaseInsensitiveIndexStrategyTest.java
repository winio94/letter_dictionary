package letters_dictionary.index_strategy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import letters_dictionary.LettersMap;

public class CaseInsensitiveIndexStrategyTest {

    @Test
    public void shouldReturnOneLetterResultWhenGivenListIsOneLetter() {
        LettersMap caseInsensitiveLettersMap = new CaseInsensitiveIndexStrategy().index(Collections.singletonList("A"));

        assertEquals("A: A", caseInsensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenListContainsOnlyOneTypeOfLetter() {
        LettersMap caseInsensitiveLettersMap = new CaseInsensitiveIndexStrategy().index(Collections.singletonList("AAAAAAA"));

        assertEquals("A: AAAAAAA", caseInsensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenListContainsTwoWordsWithOnlyOneTypeOfLetter() {
        LettersMap caseInsensitiveLettersMap = new CaseInsensitiveIndexStrategy().index(Arrays.asList("AAAAAAA", "AAAAAAA"));

        assertEquals("A: AAAAAAA", caseInsensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenListContainsTwoWordsWithOnlyOneTypeOfLetterInLowerAndUpperCase() {
        LettersMap caseInsensitiveLettersMap = new CaseInsensitiveIndexStrategy().index(Arrays.asList("AAAAAAA", "aaaaaaa"));

        assertEquals("A: AAAAAAA", caseInsensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnEachLetterOnlyOncePerWordRegardlessOfLetterFormat() {
        LettersMap caseInsensitiveLettersMap = new CaseInsensitiveIndexStrategy().index(Arrays.asList("ala", "ma", "kota", "kot", "koduje", "w", "Javie"));

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
                caseInsensitiveLettersMap.getResults());
    }
}