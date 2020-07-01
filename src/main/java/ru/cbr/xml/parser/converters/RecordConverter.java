package ru.cbr.xml.parser.converters;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import ru.cbr.xml.parser.courses.Record;

import static ru.cbr.xml.parser.courses.Record.*;

public class RecordConverter implements Converter<Record> {

    public Record read(InputNode node) throws Exception {
        Record record = new Record();
        record.setDate(node.getAttribute(DATE).getValue());
        record.setId(node.getAttribute(ID).getValue());
        InputNode next = node.getNext();
        while (next != null) {
            if (NOMINAL.equals(next.getName())) {
                record.setNominal(Integer.parseInt(next.getValue()));
            } else if (VALUE.equals(next.getName())) {
                String newString = next.getValue().trim().replace(",", ".");
                record.setValue(Double.valueOf(newString));
            }
            next = node.getNext();
        }

        return record;
    }

    public void write(OutputNode node, Record value) {
        throw new UnsupportedOperationException("Not ready converter yet");
    }
}