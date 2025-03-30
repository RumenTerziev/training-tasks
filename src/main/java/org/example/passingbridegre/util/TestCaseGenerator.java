package org.example.passingbridegre.util;

import java.util.List;
import java.util.Map;

public class TestCaseGenerator {

    public static Map<List<Double>, Double> getTestCases() {
        return Map.of(List.of(1.0, 2.0, 5.0, 10.0), 17.0,
                List.of(1.0, 3.0, 5.0, 10.0), 20.0,
                List.of(10.0, 5.0, 2.0, 1.0), 17.0,
                List.of(10.0, 3.0, 5.0, 1.0), 20.0,
                List.of(10.0, 2.0, 5.0, 1.0), 17.0);
    }
}
