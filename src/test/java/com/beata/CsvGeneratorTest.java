package com.beata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CsvGeneratorTest {

    @InjectMocks
    CsvGenerator testObj = new CsvGenerator();

    @Mock
    Sentence sentence;

    @Test
    void shouldGenerateCsvFileHeader() {

        //given
        int givenCounter = 5;
        //when
        String result = testObj.generateCsvHeader(givenCounter);
        //then
        assertThat(result).matches(", Word 1, Word 3, Word 5\n");
    }

    @Test
    void shouldReturnCsvLine() {
        //given
        int givenSentenceCounter = 1;
        when(sentence.toString())
                .thenReturn(", and, Dr., Jekyll, met, Mr., Ms., outside, Smith");

        //when
        String result = testObj.prepareCsvLine(givenSentenceCounter, sentence);

        //then
        assertThat(result).matches("Sentence 1, and, Dr., Jekyll, met, Mr., Ms., outside, Smith\n");
    }
}
