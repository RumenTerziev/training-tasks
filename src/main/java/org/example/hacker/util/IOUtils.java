package org.example.hacker.util;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class IOUtils {


    public static BufferedReader getSysInBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static BufferedWriter getSysOutBufferedWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static List<Integer> getListFromInput(BufferedReader bufferedReader) throws IOException {
        return Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
