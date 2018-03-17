package letters_dictionary;// Copyright 2018 Motorola Solutions, Inc.
// All rights Reserved.
// Motorola Solutions Confidential Restricted

public class Main {
    public static void main(String[] args) {
        LetterDictionary letterDictionary = new LetterDictionary();
        LettersMap lettersMap = letterDictionary.indexLettersPerWords("ala ma kota, kot koduje w Javie kota");

        lettersMap.getResultString();
    }
}
