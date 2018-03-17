package letters_dictionary;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import letters_dictionary.index_strategy.IndexStrategy;

public class LetterDictionary {

    private static final String NOT_AN_ALPHANUMERIC_PATTERN = "\\W+";

    public LettersMap indexLettersPerWords(String inputString, IndexStrategy indexStrategy) {
        if (emptyString(inputString)) {
            return new LettersMap();
        }
        return generateLetterMap(inputString, indexStrategy);
    }

    private boolean emptyString(String string) {
        return string == null || string.isEmpty();
    }

    private LettersMap generateLetterMap(String string, IndexStrategy indexStrategy) {
        List<String> words = splitToDistinctWords(string);
        long start = System.currentTimeMillis();
        LettersMap lettersMap = indexStrategy.index(words);
        printIndexingTime(words, indexStrategy, start);
        return lettersMap;
    }

    private List<String> splitToDistinctWords(String string) {
        return Stream.of(string.split(NOT_AN_ALPHANUMERIC_PATTERN))
                     .distinct()
                     .collect(Collectors.toList());
    }

    private void printIndexingTime(List<String> words, IndexStrategy indexStrategy, long start) {
        System.out.println(
                String.format("Indexing %s words using %s strategy took %s miliseconds.",
                        words.size(),
                        indexStrategy.getClass().getSimpleName(),
                        System.currentTimeMillis() - start));
    }
}