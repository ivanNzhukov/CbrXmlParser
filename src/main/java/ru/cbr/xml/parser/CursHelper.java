package ru.cbr.xml.parser;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import ru.cbr.xml.parser.courses.AllValCurs;
import ru.cbr.xml.parser.courses.OneValCurs;
import ru.cbr.xml.parser.valuta.Valuta;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CursHelper {
    private static final Serializer serializer = new Persister(new AnnotationStrategy());
    public static final SimpleDateFormat linkDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat standardDateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    private static final String url1 = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=%s";
    private static final String url2 = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=%1$s&date_req2=%2$s&VAL_NM_RQ=%3$s";
    private static final String url3 = "http://www.cbr.ru/scripts/XML_val.asp?d=%s";
    //ValCurs sets everyday
    private static final String SELD_FALSE = "0";
    //ValCurs sets everymonth
    private static final String SELD_TRUE = "1";

    /**
     * Method can return value in 1 month range in future
     * For example: Current day 01.01.2020 and if ask rates for 01.02.2020 then method returns AllValCurs.valuts
     * but on 02.02.2020 AllValCurs.valuts == null
     */
    public static AllValCurs getAllValutesCourses(Date date) throws Exception {
        String urlString = String.format(url1, linkDateFormatter.format(date));
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        return serializer.read(AllValCurs.class, inputStream);
    }

    public static OneValCurs getOneValCourseInDateRange(Date date1, Date date2, String valuteCode) throws Exception {
        String urlString = String.format(url2, linkDateFormatter.format(date1), linkDateFormatter.format(date2), valuteCode);
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        return serializer.read(OneValCurs.class, inputStream);
    }

    public static Valuta getDailyUpdatedValutaList() throws Exception {
        URL url = new URL(String.format(url3, SELD_FALSE));
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        return serializer.read(Valuta.class, inputStream);
    }

    public static Valuta getMonthlyUpdatedValutaList() throws Exception {
        URL url = new URL(String.format(url3, SELD_TRUE));
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        return serializer.read(Valuta.class, inputStream);
    }

}
