package ru.cbr.xml.parser;

public class Main {

    public static void main(String[] args) {

        try {
          //  System.out.println(CoursesHelper.getValutaList().toString());
          //  System.out.println(CoursesHelper.getAllValutesCourses(CoursesHelper.formatter.parse("25/06/2020")).toString());
            System.out.println(CoursesHelper.getOneValCourseInDateRange(CoursesHelper.linkDateFormatter.parse("21/06/2020"), CoursesHelper.linkDateFormatter.parse("02/07/2020"), "R01235").toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
