package com.beata;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class SentenceServiceTest {

    SentenceService testObj = new SentenceService();

    @Test
    void  shouldReturnMapContainingSentence() {
        //given
        List<String> givenWordsList = generateWordList();
        List<String> expectedSentenceWordsList = generateExpectedList();

        //when
        Map<Integer, Sentence> result = testObj.buildSentence(givenWordsList);

        //then
        assertThat(result).isNotEmpty()
                .hasSize(1)
                .containsKeys(1)
                .allSatisfy((integer, sentence) -> {
                    assertThat(sentence.getWords())
                            .hasSize(13)
                            .containsAll(expectedSentenceWordsList)
                            .startsWith("are")
                            .endsWith("you");
                });
    }

    @Test
    void shouldNotReturnMapBecauseIncompleteSentencePassed() {
        //given
        List<String> givenWordsList = new ArrayList<>();
        givenWordsList.add("met");
        givenWordsList.add("Dr.");
        givenWordsList.add("Jekyll");

        //when
        Map<Integer, Sentence> result = testObj.buildSentence(givenWordsList);

        //then
        assertThat(result).isEmpty();
    }

    private List<String> generateWordList() {

        List<String> wordList = new ArrayList<>();

        wordList.add("We");
        wordList.add("are");
        wordList.add("located");
        wordList.add("next");
        wordList.add("door");
        wordList.add("to");
        wordList.add("you");
        wordList.add("connecting");
        wordList.add("you");
        wordList.add("to");
        wordList.add("the");
        wordList.add("global");
        wordList.add("markets.");

        return wordList;
    }

    private List<String> generateExpectedList() {

        List<String> expectedList = new ArrayList<>();

        expectedList.add("We");
        expectedList.add("are");
        expectedList.add("located");
        expectedList.add("next");
        expectedList.add("door");
        expectedList.add("to");
        expectedList.add("you");
        expectedList.add("connecting");
        expectedList.add("you");
        expectedList.add("to");
        expectedList.add("the");
        expectedList.add("global");
        expectedList.add("markets");

        Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);

        return expectedList;
    }

}
