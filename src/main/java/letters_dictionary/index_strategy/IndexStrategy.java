// Copyright 2018 Motorola Solutions, Inc.
// All rights Reserved.
// Motorola Solutions Confidential Restricted

package letters_dictionary.index_strategy;

import java.util.List;

import letters_dictionary.LettersMap;
import letters_dictionary.word.Word;

@FunctionalInterface
public interface IndexStrategy<T extends Word> {
    LettersMap<T> index(List<String> words);
}