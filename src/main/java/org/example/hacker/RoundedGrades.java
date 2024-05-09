package org.example.hacker;

import java.util.ArrayList;
import java.util.List;

public class RoundedGrades {
    public static void main(String[] args) {

        System.out.println(gradingStudents(List.of(73, 67, 38, 33)));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> result = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                result.add(grade);
                continue;
            }
            int newGrade = grade;
            while (newGrade % 5 != 0) {
                newGrade++;
            }
            if (newGrade - grade < 3) {
                result.add(newGrade);
            } else {
                result.add(grade);
            }
        }
        return result;
    }
}
