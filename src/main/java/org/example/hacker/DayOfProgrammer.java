package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.example.hacker.util.IOUtils.getSysInBufferedReader;
import static org.example.hacker.util.IOUtils.getSysOutBufferedWriter;

public class DayOfProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String dayOfProgrammer(int year) {
        int dayOfProgrammer = 256;
        int yearOfCalendarChange = 1918;
        int daysOfFebruary = year == yearOfCalendarChange ? 15 : isLeapYear(year) ? 29 : 28;
        int totalDaysUnTilSeptember = 31 + daysOfFebruary + 31 + 30 + 31 + 30 + 31 + 31;
        int result = dayOfProgrammer - totalDaysUnTilSeptember;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.of(year, 9, result).format(dtf);
    }

    private static boolean isLeapYear(int year) {
        return getCalendarType(year).equals("JULIAN") ? year % 4 == 0 : year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static String getCalendarType(int year) {
        int yearOfCalendarChange = 1918;
        return year < yearOfCalendarChange ? "JULIAN" : "GREGORIAN";
    }
}
