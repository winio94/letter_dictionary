package letters_dictionary;

import letters_dictionary.index_strategy.CaseInsensitiveIndexStrategy;

public class Main {
    public static void main(String[] args) {
        LetterDictionary letterDictionary = new LetterDictionary();
        LettersMap lettersMap = letterDictionary.indexLettersPerWords("ala ma kota, kot koduje w Javie kota", new CaseInsensitiveIndexStrategy());

        System.out.println(lettersMap.getResults());
    }
}