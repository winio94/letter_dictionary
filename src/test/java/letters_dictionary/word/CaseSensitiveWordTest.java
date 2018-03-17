package letters_dictionary.word;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CaseSensitiveWordTest {

    @Test
    public void twoCaseSensitiveWordsShouldBeEqualIfTheyContainExactlyTheSameStrings() {
        CaseSensitiveWord caseSensitiveWord1 = new CaseSensitiveWord("aAaAa");
        CaseSensitiveWord caseSensitiveWord2 = new CaseSensitiveWord("aAaAa");

        assertEquals(caseSensitiveWord1, caseSensitiveWord2);
        assertEquals(caseSensitiveWord1.hashCode(), caseSensitiveWord2.hashCode());
    }

    @Test
    public void twoCaseSensitiveWordsShouldNotBeEqualIfTheyContainUpperAndLowerCaseLettersRespectively() {
        CaseSensitiveWord upperCaseWord = new CaseSensitiveWord("aaaaa");
        CaseSensitiveWord lowerCaseWord = new CaseSensitiveWord("AAAAA");

        assertNotEquals(upperCaseWord, lowerCaseWord);
        assertNotEquals(upperCaseWord.hashCode(), lowerCaseWord.hashCode());
    }
}