package org.example.maxsum.finder.impl;

import org.example.maxsum.finder.IMaxSumSeqFinder;

import java.util.*;

public class MaxSumBaseFinder implements IMaxSumSeqFinder {

    @Override
    public List<Integer> findMaxSumSeq(int[] arr) {
        NavigableMap<Integer, List<Integer>> sequences = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            List<Integer> currentSequence = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                currentSequence.add(arr[j]);
                sum += arr[j];
                sequences.put(sum, new ArrayList<>(currentSequence));
            }
        }
        return sequences.lastEntry().getValue();
    }
}
