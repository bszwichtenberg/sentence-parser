package com.beata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {

    LineService testObj = new LineService();

    @Test
    void cleanLine() {
        //given
        String givenLine = "What\the  shouted was shocking:  停在那儿, 你这肮脏的掠夺者! I couldn't understand a word,perhaps because Chinese ";

        //when
        String result = testObj.cleanLine(givenLine);

        //then
        assertThat(result).matches("What he shouted was shocking 停在那儿 你这肮脏的掠夺者! I couldn't understand a word perhaps because Chinese ");
    }

    @Test
    void shouldSplitLineIntoStringsList() {
        //given
        String givenLine = "What he shouted was shocking 停在那儿 你这肮脏的掠夺者! I couldn't understand a word perhaps because Chinese ";

        //when
        List<String> result = testObj.splitLineIntoWords(givenLine);

        //then
        assertThat(result).isInstanceOf(List.class)
                .hasSize(15)
                .contains("What","he", "shouted", "was", "shocking", "停在那儿", "你这肮脏的掠夺者!", "I", "couldn't", "understand", "a", "word", "perhaps", "because", "Chinese");
    }
}
