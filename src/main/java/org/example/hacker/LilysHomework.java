package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.hacker.util.IOUtils.*;

public class LilysHomework {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = getListFromInput(bufferedReader);

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int lilysHomework(List<Integer> arr) {
        int n = arr.size();

        List<Pair> listPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listPos.add(new Pair(arr.get(i), i));
        }

        listPos.sort(Comparator.comparingInt(pair -> pair.value));

        boolean[] visited = new boolean[n];

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || listPos.get(i).index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;

                j = listPos.get(j).index;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    private static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
