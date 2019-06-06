package com.beata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SentenceApp {

    public static void main(String[] args) {

        String line;
        String filePath = "c:\\sample_data\\small.in";
        LineService lineService = new LineService();
        SentenceService sentenceService = new SentenceService();
        XmlGenerator xmlGenerator = new XmlGenerator();
        CsvGenerator csvGenerator = new CsvGenerator();

        sentenceService.prepareFiles();

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            while((line = fileReader.readLine()) != null) {
                if(!line.isEmpty()) {
                    List<String> wordsList = lineService.splitLineIntoWords(lineService.cleanLine(line));
                    Map<Integer, Sentence> sentenceMap = sentenceService.buildSentence(wordsList);
                    if(!sentenceMap.isEmpty()) {
                        Set<Map.Entry<Integer,Sentence>> entrySet = sentenceMap.entrySet();
                        for(Map.Entry<Integer, Sentence> entry: entrySet) {
                            xmlGenerator.saveToFile(xmlGenerator.marshalSentence(entry.getValue()));
                            csvGenerator.saveToCsv(entry.getKey(), entry.getValue());
                        }
                    }
                }
             }
        } catch (IOException e) {
            System.out.println("ERROR while reading file: " + filePath);
        }

        xmlGenerator.closeXmlDocument();
        csvGenerator.createFinalCsvFile(sentenceService.getSentenceLengthCounter());
    }
}
