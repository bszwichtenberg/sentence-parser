package com.beata;

import java.util.*;


public class SentenceService {

    private Integer sentenceCounter;
    private Integer sentenceLengthCounter;
    private WordService wordService;
    private XmlGenerator xmlGenerator;
    private CsvGenerator csvGenerator;
    private List<String> tempSentence;

    public SentenceService() {

        sentenceCounter = 0;
        sentenceLengthCounter = 0;
        wordService = new WordService();
        xmlGenerator = new XmlGenerator();
        csvGenerator = new CsvGenerator();
        tempSentence = new ArrayList<>();
    }

    public Integer getSentenceLengthCounter() {
        return sentenceLengthCounter;
    }

    public void prepareFiles() {

        xmlGenerator.createDocumentHeader();
        csvGenerator.deleteIfCsvFilesAlreadyExist();
    }

    public Map<Integer, Sentence> buildSentence(List<String> wordsList) {

        Map<Integer, Sentence> sentenceMap = new HashMap<>();
        for (String word : wordsList) {
            if (!wordService.isWordContainsEndOfSentenceChar(word)) {
                tempSentence.add(word);
            } else if (wordService.isAbbreviation(word)) {
                tempSentence.add(word);
            } else {
                tempSentence.add(wordService.removeEndOfSentenceChar(word));
                Sentence sentence = copyTempListToSentence();
                tempSentence.clear();
                Collections.sort(sentence.getWords(), String.CASE_INSENSITIVE_ORDER);
                setCounters(sentence.getWords().size());
                sentenceMap.put(sentenceCounter, sentence);
            }
        }
        return sentenceMap;
    }

    private Sentence copyTempListToSentence() {

        Sentence sentence = new Sentence();

        for (String element : tempSentence) {
            sentence.getWords().add(element);
        }
        return sentence;
    }


    private void setCounters(int sentenceLengthCounter){

        sentenceCounter++;
        setSentenceLengthCounter(sentenceLengthCounter);
    }



    private void setSentenceLengthCounter(Integer sentenceLength) {

        if(sentenceLength > sentenceLengthCounter) {
            sentenceLengthCounter = sentenceLength;
        }
    }

}
