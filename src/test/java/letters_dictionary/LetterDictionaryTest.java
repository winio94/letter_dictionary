package letters_dictionary;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;

import letters_dictionary.index_strategy.IndexStrategy;

public class LetterDictionaryTest {

    @Test
    public void shouldReturnEmptyResultWhenGivenStringIsNullOrEmpty() {
        IndexStrategy indexStrategy = mock(IndexStrategy.class);

        LettersMap lettersMap1 = new LetterDictionary().indexLettersPerWords("", indexStrategy);
        LettersMap lettersMap2 = new LetterDictionary().indexLettersPerWords(null, indexStrategy);

        assertTrue(lettersMap1.isEmpty());
        assertTrue(lettersMap2.isEmpty());
        verifyNoMoreInteractions(indexStrategy);
    }

    @Test
    public void shouldCallIndexStrategyWithSplitWords() {
        IndexStrategy indexStrategy = mock(IndexStrategy.class);

        new LetterDictionary().indexLettersPerWords("AAA, BB. CC\nDD FF.", indexStrategy);

        verify(indexStrategy).index(eq(asList("AAA", "BB", "CC", "DD", "FF")));
    }
}