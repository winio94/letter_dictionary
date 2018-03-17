package letters_dictionary;

public class Main {
    public static void main(String[] args) {
        LetterDictionary letterDictionary = new LetterDictionary();
        LettersMap lettersMap = letterDictionary.indexLettersPerWords("ala ma kota, kot koduje w Javie kota");

        lettersMap.getResultString();
    }
}