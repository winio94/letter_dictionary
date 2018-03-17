package letters_dictionary;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterDictionary {

    private static final String NOT_AN_ALPHANUMERIC_PATTERN = "\\W+";

    public LettersMap indexLettersPerWords(String string) {
        if (emptyString(string)) {
            return new LettersMap();
        }
        return generateLetterMap(string);
    }

    private boolean emptyString(String string) {
        return string == null || string.isEmpty();
    }

    private LettersMap generateLetterMap(String string) {
        List<String> words = splitToDistinctWords(string);
        LettersMap lettersMap = new LettersMap();
        long start = System.currentTimeMillis();
        for (String word : words) {
            String upperCaseWord = word.toUpperCase();
            CaseInsensitiveWord caseInsensitiveWord = new CaseInsensitiveWord(word, upperCaseWord);
            char[] chars = upperCaseWord.toCharArray();
            for (char c : chars) {
                lettersMap.put(String.valueOf(c), caseInsensitiveWord);
            }
        }
        printIndexingTime(words, start);
        return lettersMap;
    }

    private List<String> splitToDistinctWords(String string) {
        return Stream.of(string.split(NOT_AN_ALPHANUMERIC_PATTERN))
                     .distinct()
                     .collect(Collectors.toList());
    }

    private void printIndexingTime(List<String> words, long start) {
        System.out.println(
                String.format("indexing %s words took %s miliseconds.",
                        words.size(),
                        System.currentTimeMillis() - start));
    }
}
