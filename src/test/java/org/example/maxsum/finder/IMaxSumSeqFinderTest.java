package org.example.maxsum.finder;

import org.example.maxsum.finder.impl.MaxSumAdvancedFinder;
import org.example.maxsum.finder.impl.MaxSumBaseFinder;
import org.example.maxsum.finder.util.TestCasesGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IMaxSumSeqFinderTest {

    private final IMaxSumSeqFinder maxSumBaseFinder = new MaxSumBaseFinder();
    private final IMaxSumSeqFinder maxSumAdvancedFinder = new MaxSumAdvancedFinder();
    private final Map<int[], List<Integer>> testCases = TestCasesGenerator.getTestCases();

    @Test
    void testBaseFindMaxSumSeq_whenGivenValidInputData() {
        //Given
        //When
        //Then
        for (Map.Entry<int[], List<Integer>> entry : testCases.entrySet()) {
            List<Integer> maxSumOfSequences = maxSumBaseFinder.findMaxSumSeq(entry.getKey());
            assertThat(entry.getValue()).isEqualTo(maxSumOfSequences);
            doTestGetNumberOccurrences(maxSumBaseFinder, entry.getKey(), entry.getValue());
        }
    }

    @Test
    void testAdvancedFindMaxSumSeq_whenGivenValidInputData() {
        //Given
        //When
        //Then
        for (Map.Entry<int[], List<Integer>> entry : testCases.entrySet()) {
            List<Integer> maxSumOfSequences = maxSumBaseFinder.findMaxSumSeq(entry.getKey());
            assertThat(entry.getValue()).isEqualTo(maxSumOfSequences);
            doTestGetNumberOccurrences(maxSumAdvancedFinder, entry.getKey(), entry.getValue());
        }
    }

    @Test
    void logBaseFinderExecutionTime() {
        Runnable runnable = () -> {
            List<Integer> maxSumSeq = maxSumBaseFinder.findMaxSumSeq(getLargeTestArray());
            System.out.println(maxSumBaseFinder.getClass().getSimpleName() + " found : " + maxSumSeq);
        };
        testRunTime(maxSumBaseFinder, runnable);
    }

    @Test
    void logAdvancedFinderExecutionTime() {
        Runnable runnable = () -> {
            List<Integer> maxSumSeq = maxSumAdvancedFinder.findMaxSumSeq(getLargeTestArray());
            System.out.println(maxSumAdvancedFinder.getClass().getSimpleName() + " found : " + maxSumSeq);
        };
        testRunTime(maxSumBaseFinder, runnable);
    }

    private void doTestGetNumberOccurrences(IMaxSumSeqFinder maxSumSeqFinder, int[] arr, List<Integer> expectedSeq) {
        List<Integer> result = maxSumSeqFinder.findMaxSumSeq(arr);
        assertThat(result).isEqualTo(expectedSeq);
    }

    private void testRunTime(IMaxSumSeqFinder maxSumFinder, Runnable runnable) {
        long currentTimeMillis = System.currentTimeMillis();
        runnable.run();
        System.out.printf("%s took %d millis for execution%n%n", maxSumFinder.getClass().getSimpleName(),
                System.currentTimeMillis() - currentTimeMillis);
    }

    private int[] getLargeTestArray() {
        int size = 2000;
        Random rand = new Random();
        int[] ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = rand.nextInt(1000);
            int luck = rand.nextInt(3);
            if (luck == 2) {
                ar[i] = ar[i] * -1;
            }
        }
        return ar;
    }
}
