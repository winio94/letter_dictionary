package letters_dictionary.index_strategy;

import java.util.List;

import letters_dictionary.word.CaseInsensitiveWord;
import letters_dictionary.LettersMap;

public class CaseInsensitiveIndexStrategy implements IndexStrategy<CaseInsensitiveWord> {

    @Override
    public LettersMap<CaseInsensitiveWord> index(List<String> words) {
        LettersMap<CaseInsensitiveWord> caseInsensitiveWordLettersMap = new LettersMap<>();
        for (String word : words) {
            String upperCaseWord = word.toUpperCase();
            CaseInsensitiveWord caseInsensitiveWord = new CaseInsensitiveWord(word, upperCaseWord);
            char[] chars = upperCaseWord.toCharArray();
            for (char c : chars) {
                caseInsensitiveWordLettersMap.put(String.valueOf(c), caseInsensitiveWord);
            }
        }
        return caseInsensitiveWordLettersMap;
    }
}