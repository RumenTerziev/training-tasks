package org.example.hacker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TimeFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        List<String> list = Arrays.stream(time.split(":"))
                .toList();
        int hours = Integer.parseInt(list.get(0));
        int minutes = Integer.parseInt(list.get(1));
        int seconds = Integer.parseInt(list.get(2)
                .replace("AM", "")
                .replace("PM", ""));

        if (hours > 12) {
            hours -= 12;
        }

        if (time.contains("AM")) {
            if (hours == 12) {
                hours -= 12;
            }
        } else if (time.contains("PM")) {
            if (hours != 12) {
                hours += 12;
            }
        }
        String result = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                .replace("24", "00");
        System.out.println(result);
    }
}
