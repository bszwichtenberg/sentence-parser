package com.beata;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class XmlGenerator {


    private FileOutputStream outputStream;
    File file;


    public XmlGenerator() {

        createXmlFile();
    }

    private void createXmlFile() {

        file = new File("out.xml");

        deleteFileIfExists(file);

        try {
            outputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteFileIfExists(File file) {

        if(file.exists()) {
            file.delete();
        }
    }

    public void createDocumentHeader() {

         String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n";
         String openingTag = "<text>\n";

        try {
            outputStream.write(xmlHeader.getBytes());
            outputStream.write(openingTag.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

     }

    public String marshalSentence(Sentence sentence) {

        StringWriter stringWriter = new StringWriter();

        try {
            Marshaller marshaller = createMarshaller();
            marshaller.marshal(sentence, stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String sentenceXml = stringWriter.toString() + "\n";
        return sentenceXml;
    }

    public void saveToFile(String sentenceXml) {

        try {
            outputStream.write(sentenceXml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Marshaller createMarshaller() {

        Marshaller marshaller = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sentence.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return marshaller;
    }

    public void closeXmlDocument() {

        String closingTag = "</text>\n";

        try {
            outputStream.write(closingTag.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


