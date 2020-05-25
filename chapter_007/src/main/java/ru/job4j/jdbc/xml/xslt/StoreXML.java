package ru.job4j.jdbc.xml.xslt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Использование JAXB
 */
public class StoreXML {
    private final File target;

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Метод сериализует в формат XML данные из list в файл target (JAXB)
     */
    public void save(List<Entry> list) {
        try (FileWriter writer = new FileWriter(target)) {
            JAXBContext context = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //перенос строк
            marshaller.marshal(new Entries(list), writer);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
