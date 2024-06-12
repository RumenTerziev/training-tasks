package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static org.example.hacker.util.IOUtils.getSysInBufferedReader;
import static org.example.hacker.util.IOUtils.getSysOutBufferedWriter;

public class ViralAdvertising {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int viralAdvertising(int n) {
        int initialNumber = 5;

        int totalLikes = 0;
        int shared = initialNumber;
        for (int day = 1; day <= n; day++) {
            int likes = shared / 2;
            int multiplier = 3;
            totalLikes += likes;
            shared = likes * multiplier;
        }
        return totalLikes;
    }
}
