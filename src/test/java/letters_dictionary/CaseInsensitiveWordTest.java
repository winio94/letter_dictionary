package letters_dictionary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CaseInsensitiveWordTest {

    @Test
    public void twoWordsHavingSameLettersShouldBeEqual() {
        CaseInsensitiveWord word1 = new CaseInsensitiveWord("abcd");
        CaseInsensitiveWord word2 = new CaseInsensitiveWord("abcd");

        assertEquals(word1, word2);
        assertEquals(word1.hashCode(), word2.hashCode());
    }

    @Test
    public void twoWordsHavingUpperAndLowerLettersRespectivelyShouldBeEqual() {
        CaseInsensitiveWord word1 = new CaseInsensitiveWord("abcd");
        CaseInsensitiveWord word2 = new CaseInsensitiveWord("ABCD");

        assertEquals(word1, word2);
        assertEquals(word1.hashCode(), word2.hashCode());
    }

}