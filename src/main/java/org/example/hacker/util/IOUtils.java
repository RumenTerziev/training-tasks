package org.example.hacker.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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

    public static List<Integer> getListFromInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
