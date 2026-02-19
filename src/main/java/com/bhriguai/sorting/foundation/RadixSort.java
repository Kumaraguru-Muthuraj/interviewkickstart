package com.bhriguai.sorting.foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.bhriguai.sorting.foundation.QuickSort.print;

//RADIXSORT
//Implement bucket/counting and radix sort
public class RadixSort {
   static class NumAndIter {
        Integer num;
        Integer iter;
        public NumAndIter(Integer num, Integer iter) {
            this.num = num;
            this.iter = iter;
        }
    }
    static ArrayList<Integer> radix_sort(ArrayList<Integer> arr) {
        int iterCount = 1;
        boolean allDone = false;
        HashMap<Integer, ArrayList<NumAndIter>> bucket = new HashMap<>();

        //First iteration.
        int mod = (int) Math.pow(10, iterCount);
        for (Integer i : arr) {
            int num = i % mod;
            int buckId = num / 10;

            bucket.put(buckId, new ArrayList<NumAndIter>());
            ArrayList<NumAndIter> nums = bucket.get(buckId);
            nums.add(new NumAndIter(i, iterCount));
        }

        iterCount++;
        //Further iterations
        while (bucket.size() > 1) {
            mod = (int) Math.pow(10, iterCount);
            for (ArrayList<NumAndIter> fromNums : bucket.values()) {
                int idx = 0;
                while (fromNums.size() > 0) {
                    if (fromNums.get(idx).iter == (iterCount - 1)) {
                        continue;
                    }
                    NumAndIter numAndIter = fromNums.remove(idx);
                    int num = numAndIter.num % mod;
                    int divBy = mod / 10;
                    int buckId = num / divBy;

                    bucket.putIfAbsent(buckId, new ArrayList<NumAndIter>());
                    ArrayList<NumAndIter> toNums = bucket.get(buckId);
                    toNums.add(new NumAndIter(numAndIter.num, iterCount + 1));
                }
            }
            iterCount++;
        }

        ArrayList<Integer> sl = new ArrayList<>();
        for (ArrayList<NumAndIter> nums : bucket.values()) {
            for (NumAndIter i : nums) {
                sl.add(i.num);
            }
        }
        return sl;
    }


    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(30, 7, 23, 30, 7, 23, 5, 30, 5, -100, -200, -100, -1000, 6,
                23, 7, 6, 3, -999,2, 9, 10, 9, 10, 9, 10, 6, 5, 3, 2));
        print(radix_sort(nums));
    }
}
