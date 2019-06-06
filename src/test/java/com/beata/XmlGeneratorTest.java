package com.beata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class XmlGeneratorTest {

    private final XmlGenerator testObj = new XmlGenerator();
    private final List<String> wordsList = new ArrayList<>();

    @BeforeEach
    public void prepareWordsList() {

        wordsList.add("and");
        wordsList.add("Dr.");
        wordsList.add("Jekyll");
        wordsList.add("met");
        wordsList.add("Mr.");
        wordsList.add("Ms.");
        wordsList.add("outside");
        wordsList.add("Smith");
    }



    @Test
    public void shouldReturnSentenceMarshaledToXmlString() {

        //given
        Sentence givenSentence = new Sentence();
        givenSentence.getWords().addAll(wordsList);
        //when
        String result = testObj.marshalSentence(givenSentence);
        //then
        assertThat(result).matches("<sentence><word>and</word><word>Dr.</word><word>Jekyll</word><word>met</word><word>Mr.</word><word>Ms.</word><word>outside</word><word>Smith</word></sentence>\n");
    }

}