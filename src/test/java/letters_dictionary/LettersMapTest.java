package letters_dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;

import letters_dictionary.word.Word;

public class LettersMapTest {

    @Test
    public void newLettersMapShouldBeEmpty() {
        LettersMap<Word> wordLettersMap = new LettersMap<>();

        assertTrue(wordLettersMap.isEmpty());
    }

    @Test
    public void mapWithOneWordShouldReturnOneResult() {
        LettersMap<Word> wordLettersMap = new LettersMap<>();

        wordLettersMap.put("A", new PrefixedWord("AAAAAA"));

        assertFalse(wordLettersMap.isEmpty());
        assertEquals("A: testprefixAAAAAA", wordLettersMap.getResults());
    }

    @Test
    public void mapShouldNotAddSameWordTwiceForLetter() {
        LettersMap<Word> wordLettersMap = new LettersMap<>();

        wordLettersMap.put("A", new PrefixedWord("AAAAAA"));
        wordLettersMap.put("A", new PrefixedWord("AAAAAA"));

        assertFalse(wordLettersMap.isEmpty());
        assertEquals("A: testprefixAAAAAA", wordLettersMap.getResults());
    }

    @Test
    public void mapWithTwoWordsPerSameLetterShouldReturnTwoWordsResultJoinedByComma() {
        LettersMap<Word> wordLettersMap = new LettersMap<>();

        wordLettersMap.put("A", new PrefixedWord("AAAAAA"));
        wordLettersMap.put("A", new PrefixedWord("AAAA"));

        assertFalse(wordLettersMap.isEmpty());
        assertEquals("A: testprefixAAAAAA, testprefixAAAA", wordLettersMap.getResults());
    }

    @Test
    public void mapWithWordPerDifferentLetterShouldReturnTwoWordsResultDividedByNewLine() {
        LettersMap<Word> wordLettersMap = new LettersMap<>();

        wordLettersMap.put("A", new PrefixedWord("AAAAAA"));
        wordLettersMap.put("B", new PrefixedWord("BBBBBB"));

        assertFalse(wordLettersMap.isEmpty());
        assertEquals(
                "A: testprefixAAAAAA\n" +
                        "B: testprefixBBBBBB",
                wordLettersMap.getResults());
    }

    private static class PrefixedWord implements Word {

        static final String PREFIX = "testprefix";
        private final String word;

        public PrefixedWord(String word) {
            this.word = word;
        }

        @Override
        public String value() {
            return PREFIX + word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PrefixedWord prefixedWord = (PrefixedWord) o;
            return Objects.equals(word, prefixedWord.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }
    }
}