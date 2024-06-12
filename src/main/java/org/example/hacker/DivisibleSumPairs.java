package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import static org.example.hacker.util.IOUtils.*;

public class DivisibleSumPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = getListFromInput(bufferedReader);

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;
        for (int indexOne = 0; indexOne < n; indexOne++) {
            for (int indexTwo = indexOne; indexTwo < n; indexTwo++) {
                if (indexOne == indexTwo) {
                    continue;
                }
                if ((ar.get(indexOne) + ar.get(indexTwo)) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
