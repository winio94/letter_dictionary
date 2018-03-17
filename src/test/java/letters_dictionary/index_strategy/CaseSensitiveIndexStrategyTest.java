package letters_dictionary.index_strategy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import letters_dictionary.LettersMap;

public class CaseSensitiveIndexStrategyTest {

    @Test
    public void shouldReturnOneLetterResultWhenGivenListIsOneLetter() {
        LettersMap caseSensitiveLettersMap = new CaseSensitiveIndexStrategy().index(Collections.singletonList("A"));

        assertEquals("A: A", caseSensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenListContainsOnlyOneTypeOfLetter() {
        LettersMap caseSensitiveLettersMap = new CaseSensitiveIndexStrategy().index(Collections.singletonList("AAAAAAA"));

        assertEquals("A: AAAAAAA", caseSensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnOneLetterResultWhenGivenListContainsTwoWordsWithOnlyOneTypeOfLetter() {
        LettersMap caseSensitiveLettersMap = new CaseSensitiveIndexStrategy().index(Arrays.asList("AAAAAAA", "AAAAAAA"));

        assertEquals("A: AAAAAAA", caseSensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnTwoLetterResultWhenGivenListContainsTwoSameWordsWithLettersInLowerAndUpperCase() {
        LettersMap caseSensitiveLettersMap = new CaseSensitiveIndexStrategy().index(Arrays.asList("AAAAAAA", "aaaaaaa"));

        assertEquals(
                "A: AAAAAAA\n" +
                        "a: aaaaaaa",
                caseSensitiveLettersMap.getResults());
    }

    @Test
    public void shouldReturnEachLetterOnlyOncePerWordDependingOnLetterFormat() {
        LettersMap caseSensitiveLettersMap = new CaseSensitiveIndexStrategy().index(Arrays.asList("ala", "ma", "kota", "kot", "koduje", "w", "Javie"));

        assertEquals(
                "a: ala, ma, kota, Javie\n" +
                        "d: koduje\n" +
                        "e: koduje, Javie\n" +
                        "i: Javie\n" +
                        "j: koduje\n" +
                        "J: Javie\n" +
                        "k: kota, kot, koduje\n" +
                        "l: ala\n" +
                        "m: ma\n" +
                        "o: kota, kot, koduje\n" +
                        "t: kota, kot\n" +
                        "u: koduje\n" +
                        "v: Javie\n" +
                        "w: w",
                caseSensitiveLettersMap.getResults());
    }
}