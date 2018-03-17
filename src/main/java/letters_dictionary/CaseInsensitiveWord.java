package letters_dictionary;// Copyright 2018 Motorola Solutions, Inc.
// All rights Reserved.
// Motorola Solutions Confidential Restricted

import java.util.Objects;

public class CaseInsensitiveWord {
    private final String word;
    private final String upperCaseWord;

    public CaseInsensitiveWord(String word,
                               String upperCaseWord) {
        this.word = word;
        this.upperCaseWord = upperCaseWord;
    }

    public CaseInsensitiveWord(String word) {
        this(word, word.toUpperCase());
    }

    public String value() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseInsensitiveWord caseInsensitiveWord1 = (CaseInsensitiveWord) o;
        return Objects.equals(upperCaseWord, caseInsensitiveWord1.upperCaseWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upperCaseWord);
    }
}