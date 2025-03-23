package org.example;

import java.util.ArrayList;
import java.util.List;

public class TestingStuff {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            if (i % 2 == 0) {
                myList.add("test" + "even");
            } else {
                myList.add("test" + "odd");
            }
        }
        System.out.println(myList.size());
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
