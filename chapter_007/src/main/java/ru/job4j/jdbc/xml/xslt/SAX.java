package ru.job4j.jdbc.xml.xslt;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAX {
    public static int sum;

    /**
     * Метод парсит файл и выводит арифметическую сумму значений всех атрибутов field в консоль
     */
    public void parse(String source) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(source), handler);
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                int field = Integer.parseInt(attributes.getValue("field"));
                sum = sum + field;
            }
        }
    }
}
