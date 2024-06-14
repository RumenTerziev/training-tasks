package org.example.hacker;

import org.example.hacker.util.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static org.example.hacker.util.IOUtils.getSysInBufferedReader;
import static org.example.hacker.util.IOUtils.getSysOutBufferedWriter;

public class AngryProfessor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> a = IOUtils.getListFromInput(bufferedReader);

                String result = angryProfessor(k, a);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String angryProfessor(int k, List<Integer> a) {
        int numberOfStudentsArrivedOnTime = 0;
        for (Integer integer : a) {
            if (integer <= 0) {
                numberOfStudentsArrivedOnTime++;
            }
        }
        if (numberOfStudentsArrivedOnTime >= k) {
            return "NO";
        }
        return "YES";
    }
}
