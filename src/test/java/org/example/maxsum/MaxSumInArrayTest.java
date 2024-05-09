package org.example.maxsum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MaxSumInArrayTest {

    @Test
    void testGetMaxSumOfSequences_whenGivenValidInputData() {
        //Given
        Map<int[], List<Integer>> testCases = new LinkedHashMap<>();
        testCases.put(new int[]{1, -1, 2, 5, -4, 3, 8, -1, 2, -5000, 30000}, List.of(30000));
        testCases.put(new int[]{-1, 30000}, List.of(30000));
        testCases.put(new int[]{2, -1, 8, -5, -4, -1, 2}, Arrays.asList(2, -1, 8));
        testCases.put(new int[]{5, -6, 2, -1, 8, -1, 2, -1}, Arrays.asList(2, -1, 8, -1, 2));
        testCases.put(new int[]{1, 2, 3}, Arrays.asList(1, 2, 3));

        //When
        //Then
        for (Map.Entry<int[], List<Integer>> entry : testCases.entrySet()) {
            List<Integer> maxSumOfSequences = MaxSumInArray.getMaxSumOfSequences(entry.getKey());
            assertThat(entry.getValue()).isEqualTo(maxSumOfSequences);
        }
    }
}
