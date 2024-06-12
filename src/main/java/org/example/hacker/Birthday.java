package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import static org.example.hacker.util.IOUtils.*;

public class Birthday {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = getListFromInput(bufferedReader);

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int birthday(List<Integer> s, int d, int m) {
        if (s.size() == 1) {
            return s.get(0) == d && m == 1 ? 1 : 0;
        }
        int countSolutions = 0;
        for (int index = 0; index <= s.size() - m; index++) {
            int sum = s.subList(index, index + m).stream()
                    .reduce(0, Integer::sum);
            if (sum == d) {
                countSolutions++;
            }
        }
        return countSolutions;
    }
}
