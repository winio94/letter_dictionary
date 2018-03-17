package letters_dictionary;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import letters_dictionary.word.Word;

public class LettersMap<T extends Word> {

    private static final String NEW_LINE = "\n";
    private static final String COMMA_AND_SPACE = ", ";
    private static final String COLON_AND_SPACE = ": ";
    private final Map<String, Set<T>> wordsPerLetters;

    public LettersMap() {
        this.wordsPerLetters = new HashMap<>();
    }

    public boolean isEmpty() {
        return wordsPerLetters.isEmpty();
    }

    public void put(final String letter, final T word) {
        Set<T> wordsPerLetter = getWordsContainingLetter(letter);
        wordsPerLetter.add(word);
        wordsPerLetters.put(letter, wordsPerLetter);
    }

    public String getResults() {
        return wordsPerLetters.entrySet()
                              .stream()
                              .map(entryToLetterOccurrence())
                              .collect(Collectors.joining(NEW_LINE));
    }

    private Function<Map.Entry<String, Set<T>>, String> entryToLetterOccurrence() {
        return entry -> {
            String letter = entry.getKey();
            Set<T> wordsContainingLetter = entry.getValue();
            return letter + COLON_AND_SPACE + getWordsContainingLetterAsString(wordsContainingLetter);
        };
    }

    private Set<T> getWordsContainingLetter(String letter) {
        Set<T> wordsPerLetter = wordsPerLetters.get(letter);
        if (wordsPerLetter == null) {
            wordsPerLetter = new LinkedHashSet<>();
        }
        return wordsPerLetter;
    }

    private String getWordsContainingLetterAsString(Set<T> wordsContainingLetter) {
        return wordsContainingLetter.stream()
                                    .map(Word::value)
                                    .collect(Collectors.joining(COMMA_AND_SPACE));
    }
}