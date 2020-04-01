package ru.job4j.jdbc.xml.xslt;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "entries")
@XmlRootElement
public class Entries {
    @XmlElement(name = "entry")
    private List<Entry> list;

    public Entries() {
    }

    public Entries(List<Entry> list) {
        this.list = list;
    }


}
