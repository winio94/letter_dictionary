// Copyright 2018 Motorola Solutions, Inc.
// All rights Reserved.
// Motorola Solutions Confidential Restricted

package letters_dictionary.word;

import java.util.Objects;

public class CaseSensitiveWord implements Word {

    private final String word;

    public CaseSensitiveWord(String word) {
        this.word = word;
    }

    @Override
    public String value() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseSensitiveWord that = (CaseSensitiveWord) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}