package ru.cbr.xml.parser.valuta;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Item {
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String ENGNAME = "EngName";
    public static final String NOMINAL = "Nominal";
    public static final String PARENTCODE = "ParentCode";

    @Attribute(name = ID)
    private String id;
    @Element(name = NAME)
    private String name;
    @Element(name = ENGNAME)
    private String engName;
    @Element(name = NOMINAL)
    private int nominal;
    @Element(name = PARENTCODE)
    private String parentCode;

    public Item(@Attribute(name = ID) String id,
                @Element(name = NAME) String name,
                @Element(name = ENGNAME) String engName,
                @Element(name = NOMINAL) int nominal,
                @Element(name = PARENTCODE) String parentCode) {
        this.id = id;
        this.name = name;
        this.engName = engName;
        this.nominal = nominal;
        this.parentCode = parentCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", engName='").append(engName).append('\'');
        sb.append(", nominal=").append(nominal);
        sb.append(", parentCode='").append(parentCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
