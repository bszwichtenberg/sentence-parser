package com.beata;

import java.util.Arrays;
import java.util.List;

public class LineService {


    public String cleanLine(String line) {

        final String REGEX_WHITESPACE_BEGINNING_END = "(^\\s+)(.+)(\\s$)";
        final String REGEX_REDUNDANT_WHITESPACES = "\\s+";
        final String REGEX_WHITESPACES_BEFORE_PUNCTUATION = "(\\w)(\\s+)([.!?])";
        final String REGEX_OTHER_CHARACTERS_TO_REMOVE = "[()\\-:,]";

        return line.replaceAll(REGEX_WHITESPACE_BEGINNING_END, "$2")
                .replaceAll(REGEX_OTHER_CHARACTERS_TO_REMOVE, " " )
                .replaceAll(REGEX_WHITESPACES_BEFORE_PUNCTUATION, "$1$3")
                .replaceAll(REGEX_REDUNDANT_WHITESPACES, " ");
    }

    public List<String> splitLineIntoWords(String line ){

        final String SEPARATOR = " ";

        return Arrays.asList(line.split(SEPARATOR));
    }
}
