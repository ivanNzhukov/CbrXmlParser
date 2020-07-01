package ru.cbr.xml.parser.valuta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class Valuta {

    public static final String NAME = "name";
    public static final String ITEM = "Item";

    @Attribute(name = NAME, required = false)
    private String name;
    @ElementList(entry = ITEM, inline = true)
    private List<Item> items;


    public Valuta(@Attribute(name = NAME, required = false) String name,
                  @ElementList(entry = ITEM, inline = true) List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Valuta{");
        sb.append("name='").append(name).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
