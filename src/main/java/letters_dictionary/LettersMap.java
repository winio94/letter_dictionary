package letters_dictionary;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LettersMap {

    private static final String NEW_LINE = "\n";
    private static final String COMMA_AND_SPACE = ", ";
    private static final String COLON_AND_SPACE = ": ";
    private final Map<String, Set<CaseInsensitiveWord>> wordsPerLetters;

    public LettersMap() {
        this.wordsPerLetters = new HashMap<>();
    }

    public boolean isEmpty() {
        return wordsPerLetters.isEmpty();
    }

    public String getResultString() {
        return wordsPerLetters.entrySet()
                              .stream()
                              .map(entryToLetterOccurrence())
                              .collect(Collectors.joining(NEW_LINE));
    }

    public void put(String letter, CaseInsensitiveWord caseInsensitiveWord) {
        Set<CaseInsensitiveWord> wordsPerLetter = getWordsContainingLetter(letter);
        wordsPerLetter.add(caseInsensitiveWord);
        wordsPerLetters.put(letter, wordsPerLetter);
    }

    private Function<Map.Entry<String, Set<CaseInsensitiveWord>>, String> entryToLetterOccurrence() {
        return entry -> {
            String letter = entry.getKey();
            Set<CaseInsensitiveWord> wordsContainingLetter = entry.getValue();
            return letter + COLON_AND_SPACE + getWordsContainingLetterAsString(wordsContainingLetter);
        };
    }

    private Set<CaseInsensitiveWord> getWordsContainingLetter(String letter) {
        Set<CaseInsensitiveWord> wordsPerLetter = wordsPerLetters.get(letter);
        if (wordsPerLetter == null) {
            wordsPerLetter = new LinkedHashSet<>();
        }
        return wordsPerLetter;
    }

    private String getWordsContainingLetterAsString(Set<CaseInsensitiveWord> wordsContainingLetter) {
        return wordsContainingLetter.stream()
                                    .map(CaseInsensitiveWord::value)
                                    .collect(Collectors.joining(COMMA_AND_SPACE));
    }
}
