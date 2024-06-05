package org.example.hacker;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingRecords {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int minValue = scores.get(0);
        int maxValue = scores.get(0);

        int countBreakingRecord = 0;
        int countScoringLessPoints = 0;
        for (Integer score : scores) {
            if (score < minValue) {
                minValue = score;
                countScoringLessPoints++;
            } else if (score > maxValue) {
                maxValue = score;
                countBreakingRecord++;
            }
        }
        return List.of(countBreakingRecord, countScoringLessPoints);
    }
}
