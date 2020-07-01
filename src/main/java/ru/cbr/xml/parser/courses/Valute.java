package ru.cbr.xml.parser.courses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;
import ru.cbr.xml.parser.converters.ValuteConverter;

@Root(name = "Valute")
@Convert(ValuteConverter.class)
public class Valute {
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String NUMCODE = "NumCode";
    public static final String NOMINAL = "Nominal";
    public static final String CHARCODE = "CharCode";
    public static final String VALUE = "Value";

    @Attribute(name = ID)
    private String id;
    @Element(name = NUMCODE)
    private String numCode;
    @Element(name = CHARCODE)
    private String charCode;
    @Element(name = NOMINAL)
    private int nominal;
    @Element(name = NAME)
    private String name;
    @Element(name = VALUE)
    private Double value;

    public Valute() {
    }

    public Valute(@Attribute(name = ID) String id,
                  @Element(name = NUMCODE) String numCode,
                  @Element(name = CHARCODE) String charCode,
                  @Element(name = NOMINAL) int nominal,
                  @Element(name = NAME) String name,
                  @Element(name = VALUE) Double value) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Valute{");
        sb.append("id='").append(id).append('\'');
        sb.append(", numCode='").append(numCode).append('\'');
        sb.append(", charCode='").append(charCode).append('\'');
        sb.append(", nominal=").append(nominal);
        sb.append(", name='").append(name).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
