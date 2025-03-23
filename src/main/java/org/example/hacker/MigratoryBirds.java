package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.hacker.util.IOUtils.*;

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = getListFromInput(bufferedReader);

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        for (Integer element : arr) {
            occurrencesMap.putIfAbsent(element, 0);
            occurrencesMap.put(element, occurrencesMap.get(element) + 1);
        }
        System.out.println(occurrencesMap);
        return occurrencesMap.entrySet().stream()
                .min((f, s) -> s.getValue() - f.getValue())
                .orElseThrow(IllegalArgumentException::new)
                .getKey();
    }
}
