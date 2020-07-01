package ru.cbr.xml.parser.courses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class AllValCurs {
    public static final String DATE = "Date";
    public static final String NAME = "name";
    public static final String VALUTE = "Valute";

    @Attribute(name = DATE)
    private String date;
    @Attribute(name = NAME)
    private String name;
    @ElementList(inline = true, entry = VALUTE,required = false)
    private List<Valute> valuts;


    public AllValCurs(
            @Attribute(name = DATE) String date,
            @Attribute(name = NAME) String name,
            @ElementList(inline = true, entry = VALUTE) List<Valute> valuts) {
        this.date = date;
        this.name = name;
        this.valuts = valuts;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Valute> getValuts() {
        return valuts;
    }

    public void setValuts(List<Valute> valuts) {
        this.valuts = valuts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AllValCurs{");
        sb.append("date='").append(date).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", valuts=").append(valuts);
        sb.append('}');
        return sb.toString();
    }
}
