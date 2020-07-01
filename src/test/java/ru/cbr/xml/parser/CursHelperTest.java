package ru.cbr.xml.parser;

import org.junit.jupiter.api.Test;
import ru.cbr.xml.parser.courses.AllValCurs;
import ru.cbr.xml.parser.courses.OneValCurs;
import ru.cbr.xml.parser.valuta.Valuta;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CursHelperTest {

    String WORK_DAY = "25/06/2020";
    String NOT_WORK_DAY = "04/07/2020";
    String USD = "R01235";

    @Test
    public void test_dailyUpdatedValutaList_neverNull() throws Exception {
        Valuta valuta = CursHelper.getDailyUpdatedValutaList();
        assertNotNull(valuta);
    }

    @Test
    public void test_monthlyUpdatedValutaList_neverNull() throws Exception {
        Valuta valuta = CursHelper.getMonthlyUpdatedValutaList();
        assertNotNull(valuta);
    }

    @Test
    public void AllValCurs_NotNull_in_workDay() throws Exception {
        AllValCurs allValCurs = CursHelper.getAllValutesCourses(CursHelper.linkDateFormatter.parse(WORK_DAY));
        assertNotNull(allValCurs);
    }

    @Test
    public void AllValCurs_NotNull_in_not_workDay() throws Exception {
        AllValCurs allValCurs = CursHelper.getAllValutesCourses(CursHelper.linkDateFormatter.parse(NOT_WORK_DAY));
        assertNotNull(allValCurs);
    }

    @Test
    public void AllValCurs_NotNull_in_future() throws Exception {
        AllValCurs allValCurs = CursHelper.getAllValutesCourses(getFutureYear());
        assertNotNull(allValCurs);
    }

    @Test
    public void List_Valute_NotNull_in_workDay() throws Exception {
        AllValCurs allValCurs = CursHelper.getAllValutesCourses(CursHelper.linkDateFormatter.parse(WORK_DAY));
        assertNotNull(allValCurs);
        assertNotNull(allValCurs.getValuts());
    }

    @Test
    public void List_Valute_NotNull_in_not_workDay() throws Exception {
        AllValCurs allValCurs = CursHelper.getAllValutesCourses(CursHelper.linkDateFormatter.parse(NOT_WORK_DAY));
        assertNotNull(allValCurs);
        assertNotNull(allValCurs.getValuts());
    }

    @Test
    public void List_Valute_Null_in_future() throws Exception {
        AllValCurs allValCurs = CursHelper.getAllValutesCourses(getFutureYear());
        assertNotNull(allValCurs);
        assertNull(allValCurs.getValuts());
    }

    @Test
    public void OneValCursInDateRange_NotNull_in_workDay() throws Exception {
        OneValCurs oneValCurs = CursHelper.getOneValCourseInDateRange(CursHelper.linkDateFormatter.parse(WORK_DAY), CursHelper.linkDateFormatter.parse(NOT_WORK_DAY), USD);
        assertNotNull(oneValCurs);
    }

    @Test
    public void OneValCurseInDateRange_NotNull_in_not_workDay() throws Exception {
        OneValCurs oneValCurs = CursHelper.getOneValCourseInDateRange(CursHelper.linkDateFormatter.parse(NOT_WORK_DAY), CursHelper.linkDateFormatter.parse(NOT_WORK_DAY), USD);
        assertNotNull(oneValCurs);
    }

    @Test
    public void List_Record_NotNull_in_workDay() throws Exception {
        OneValCurs oneValCurs = CursHelper.getOneValCourseInDateRange(CursHelper.linkDateFormatter.parse(WORK_DAY), CursHelper.linkDateFormatter.parse(NOT_WORK_DAY), USD);
        assertNotNull(oneValCurs);
        assertNotNull(oneValCurs.getRecords());
    }

    @Test
    public void List_Record_Null_in_not_workDay() throws Exception {
        OneValCurs oneValCurs = CursHelper.getOneValCourseInDateRange(CursHelper.linkDateFormatter.parse(NOT_WORK_DAY), CursHelper.linkDateFormatter.parse(NOT_WORK_DAY), USD);
        assertNotNull(oneValCurs);
        assertNull(oneValCurs.getRecords());
    }

    private Date getFutureYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.YEAR, 1);
        return c.getTime();
    }
}
