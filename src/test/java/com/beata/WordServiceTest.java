package com.beata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class WordServiceTest {

    WordService testObj = new WordService();

    @Test
    void shouldReturnThatWordIsAbbreviation() {

        //given
        String givenWord = "Dr.";
        //when
        boolean result = testObj.isAbbreviation(givenWord);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnThatWordIsNotAbbreviation() {

        //given
        String givenWord = "his.";
        //when
        boolean result = testObj.isAbbreviation(givenWord);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnThatWordIsEndOfSentence() {

        //given
        String givenWord = "markets!";
        //when
        boolean result = testObj.isWordContainsEndOfSentenceChar(givenWord);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnThatWordIsNotEndOfSentence() {

        //given
        String givenWord = "shouted";
        //when
        boolean result = testObj.isWordContainsEndOfSentenceChar(givenWord);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldRemoveDotInGivenString() {

        //given
        String givenWord = "regions.";
        //when
        String result = testObj.removeEndOfSentenceChar(givenWord);
        //then
        assertThat(result).matches("regions");
    }

    @Test
    void shouldReturnGivenString() {

        //given
        String givenWord = "located";
        //when
        String result = testObj.removeEndOfSentenceChar(givenWord);
        //then
        assertThat(result).matches("located");
    }
}
