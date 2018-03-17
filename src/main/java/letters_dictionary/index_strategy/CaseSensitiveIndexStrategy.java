package letters_dictionary.index_strategy;

import java.util.List;

import letters_dictionary.LettersMap;
import letters_dictionary.word.CaseSensitiveWord;

public class CaseSensitiveIndexStrategy implements IndexStrategy<CaseSensitiveWord> {

    @Override
    public LettersMap<CaseSensitiveWord> index(List<String> words) {
        LettersMap<CaseSensitiveWord> caseSensitiveWordLettersMap = new LettersMap<>();
        for (String word : words) {
            CaseSensitiveWord caseSensitiveWord = new CaseSensitiveWord(word);
            char[] chars = word.toCharArray();
            for (char c : chars) {
                caseSensitiveWordLettersMap.put(String.valueOf(c), caseSensitiveWord);
            }
        }
        return caseSensitiveWordLettersMap;
    }
}