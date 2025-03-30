package org.example.passingbridgere;

import org.example.passingbridegre.PassingBridge;
import org.example.passingbridegre.util.TestCaseGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PassingBridgeTest {


    private final Map<List<Double>, Double> testCases = TestCaseGenerator.getTestCases();
    private final PassingBridge passingBridge = new PassingBridge();

    @Test
    void test_getMinPassingTime() {
        //Given
        //When
        //Then
        for (Map.Entry<List<Double>, Double> entry : testCases.entrySet()) {
            double minPassingTime = this.passingBridge.getMinPassingTime(entry.getKey());
            assertThat(entry.getValue()).isEqualTo(minPassingTime);
        }
    }
}
