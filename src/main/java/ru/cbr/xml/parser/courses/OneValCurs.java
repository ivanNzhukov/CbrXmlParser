package ru.cbr.xml.parser.courses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class OneValCurs {
    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String DATE_RANGE1 = "DateRange1";
    public static final String DATE_RANGE2 = "DateRange2";
    public static final String RECORD = "Record";

    @Attribute(name = ID)
    private String id;
    @Attribute(name = NAME)
    private String name;
    @Attribute(name = DATE_RANGE1)
    private String dateRange1;
    @Attribute(name = DATE_RANGE2)
    private String dateRange2;
    @ElementList(inline = true, entry = RECORD)
    private List<Record> records;


    public OneValCurs(@Attribute(name = ID) String id,
                      @Attribute(name = NAME) String name,
                      @Attribute(name = DATE_RANGE1) String dateRange1,
                      @Attribute(name = DATE_RANGE2) String dateRange2,
                      @ElementList(inline = true, entry = RECORD) List<Record> records) {
        this.id = id;
        this.name = name;
        this.dateRange1 = dateRange1;
        this.dateRange2 = dateRange2;
        this.records = records;
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

    public String getDateRange1() {
        return dateRange1;
    }

    public void setDateRange1(String dateRange1) {
        this.dateRange1 = dateRange1;
    }

    public String getDateRange2() {
        return dateRange2;
    }

    public void setDateRange2(String dateRange2) {
        this.dateRange2 = dateRange2;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OneValCurs{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", dateRange1='").append(dateRange1).append('\'');
        sb.append(", dateRange2='").append(dateRange2).append('\'');
        sb.append(", records=").append(records);
        sb.append('}');
        return sb.toString();
    }
}
