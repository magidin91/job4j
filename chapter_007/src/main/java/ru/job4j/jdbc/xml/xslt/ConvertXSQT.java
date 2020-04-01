package ru.job4j.jdbc.xml.xslt;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Использование XSLT
 */
public class ConvertXSQT {
    /**
     * Метод  конвертирует XML файл источника на основе схемы XSLT
     */
    public void convert(File source, File dest, File scheme) {
        try (FileInputStream inScheme = new FileInputStream(scheme);
             FileInputStream inSource = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(dest)) {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(inScheme));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.transform(new StreamSource(inSource), new StreamResult(out));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

