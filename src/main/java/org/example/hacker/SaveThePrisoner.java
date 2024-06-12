package org.example.hacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.IntStream;

import static org.example.hacker.util.IOUtils.getSysInBufferedReader;
import static org.example.hacker.util.IOUtils.getSysOutBufferedWriter;

public class SaveThePrisoner {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = getSysInBufferedReader();
        BufferedWriter bufferedWriter = getSysOutBufferedWriter();

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = saveThePrisoner(n, m, s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int saveThePrisoner(int countChairs, int countSweets, int startingChair) {
        int result;
        int module = countSweets % countChairs;
        if (module == 0) {
            result = startingChair - 1;
            return result == 0 ? countChairs : result;
        }
        result = module + startingChair - 1;
        return result > countChairs ? result % countChairs : result;
    }
}
