package ru.cbr.xml.parser.courses;

import ru.cbr.xml.parser.converters.RecordConverter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import java.math.BigDecimal;

@Root
@Convert(RecordConverter.class)
public class Record {
    public static final String DATE = "Date";
    public static final String ID = "Id";
    public static final String NOMINAL = "Nominal";
    public static final String VALUE = "Value";

    @Attribute(name = DATE)
    private String date;
    @Attribute(name = ID)
    private String id;
    @Element(name = NOMINAL)
    private int nominal;
    @Element(name = VALUE)
    private BigDecimal value;

    public Record() {
    }

    public Record(@Attribute(name = DATE) String date,
                  @Attribute(name = ID) String id,
                  @Element(name = NOMINAL) int nominal,
                  @Element(name = VALUE) BigDecimal value) {
        this.date = date;
        this.id = id;
        this.nominal = nominal;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Record{");
        sb.append("date='").append(date).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", nominal=").append(nominal);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
