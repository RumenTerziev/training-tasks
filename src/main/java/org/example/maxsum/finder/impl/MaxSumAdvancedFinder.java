package org.example.maxsum.finder.impl;

import org.example.maxsum.finder.IMaxSumSeqFinder;

import java.util.*;

public class MaxSumAdvancedFinder implements IMaxSumSeqFinder {

    @Override
    public List<Integer> findMaxSumSeq(int[] ar) {
        R max = null;
        R current = null;

        for (int i = 0; i < ar.length; i++) {
            if (i == 0 || current.sum < 0) {
                current = new R(i, i, ar[i]);
            } else {
                current.sum += ar[i];
                current.end = i;
            }
            if (max == null || max.sum < current.sum) {
                max = new R(current.start, current.end, current.sum);
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= Objects.requireNonNull(max).end - max.start; i++) {
            res.add(ar[max.start + i]);
        }
        return res;
    }

    private static class R {
        private final Integer start;
        private Integer end;
        private Integer sum;

        public R(Integer start, Integer end, Integer sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
}