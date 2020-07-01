package ru.cbr.xml.parser.converters;

import ru.cbr.xml.parser.courses.Valute;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.math.BigDecimal;

import static ru.cbr.xml.parser.courses.Valute.*;

public class ValuteConverter implements Converter<Valute> {
    public Valute read(InputNode node) throws Exception {
        Valute valute = new Valute();
        valute.setId(node.getAttribute(ID).getValue());

        InputNode next = node.getNext();
        while (next != null) {
            if (NUMCODE.equals(next.getName())) {
                valute.setNumCode(next.getValue());
            } else if (CHARCODE.equals(next.getName())) {
                valute.setCharCode(next.getValue());
            } else if (NOMINAL.equals(next.getName())) {
                valute.setNominal(Integer.parseInt(next.getValue()));
            } else if (NAME.equals(next.getName())) {
                valute.setName(next.getValue());
            } else if (VALUE.equals(next.getName())) {
                String newString = next.getValue().trim().replace(",", ".");
                valute.setValue(Double.valueOf(newString));
            }
            next = node.getNext();
        }
        return valute;
    }

    public void write(OutputNode node, Valute value) {
        throw new UnsupportedOperationException("Not ready converter yet");
    }
}
