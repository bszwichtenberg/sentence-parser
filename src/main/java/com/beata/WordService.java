package com.beata;

public class WordService {

    public boolean isAbbreviation(String word) {

        final String REGEX_ABBREVIATIONS = "[A-Z]{1}+[a-z]{1,2}+\\.+";

        if (word.matches(REGEX_ABBREVIATIONS)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWordContainsEndOfSentenceChar(String word) {

        final String REGEX_END_OF_SENTENCE = "(.+)([.!?])";

        if (word.matches(REGEX_END_OF_SENTENCE)) {
            return true;
        } else {
            return false;
        }
    }

    public String removeEndOfSentenceChar(String word) {

        final String REGEX_END_OF_SENTENCE = "(.+)([.!?])";

        return word.replaceAll(REGEX_END_OF_SENTENCE, "$1");
    }
}
