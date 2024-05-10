package org.example.maxsum;

import org.example.maxsum.finder.IMaxSumSeqFinder;
import org.example.maxsum.finder.impl.MaxSumBaseFinder;
import org.example.maxsum.finder.impl.MaxSumAdvancedFinder;
import org.example.maxsum.finder.util.TestCasesGenerator;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        IMaxSumSeqFinder maxSumBaseFinder = new MaxSumBaseFinder();
        IMaxSumSeqFinder maxSumAdvancedFinder = new MaxSumAdvancedFinder();
        Map<int[], List<Integer>> testCases = TestCasesGenerator.getTestCases();
        int[] largeTestArray = TestCasesGenerator.getLargeTestArray();

        List<Integer> maxSumSeq = maxSumBaseFinder.findMaxSumSeq(largeTestArray);
        System.out.println(maxSumSeq);

        System.out.println("Base finder results ->");
        for (int[] key : testCases.keySet()) {
            System.out.println(maxSumBaseFinder.findMaxSumSeq(key));
        }
        System.out.println("Advanced finder results ->");
        for (int[] key : testCases.keySet()) {
            System.out.println(maxSumAdvancedFinder.findMaxSumSeq(key));
        }
    }
}
