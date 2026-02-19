package com.bhriguai.sorting.foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.bhriguai.sorting.foundation.QuickSort.print;

//RADIXSORT - This worked but took a lot of time for large set. Perhaps the object creation with version took time.
//only 15/19 cases succeeded.
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
        int maxIter = Integer.MIN_VALUE;
        HashMap<Integer, ArrayList<NumAndIter>> bucket = new HashMap<>();

        //First iteration.
        int mod = (int) Math.pow(10, iterCount);
        for (Integer i : arr) {
            int numDigits = (int) Math.floor(Math.log10(i)) + 1;
            maxIter = Math.max(maxIter, numDigits);
            int buckId = i % mod;

            bucket.putIfAbsent(buckId, new ArrayList<NumAndIter>());
            ArrayList<NumAndIter> nums = bucket.get(buckId);
            nums.add(new NumAndIter(i, iterCount));
        }
        maxIter += 1;
        iterCount++;
        //Further iterations
        while (iterCount <= maxIter + 1) {
            mod = (int) Math.pow(10, iterCount);
            //There can only be 10 buckets from 0 - 9
            for (int i = 0; i < 10; i++) {
                ArrayList<NumAndIter> fromNums = bucket.get(i);
                if (fromNums == null || fromNums.size() == 0) {
                    continue;
                }
                int idx = 0;
                while (fromNums.size() > 0) {
                    if (fromNums.get(idx).iter > (iterCount - 1)) {
                        break;
                    }
                    NumAndIter numAndIter = fromNums.remove(idx);
                    int num = numAndIter.num % mod;
                    int divBy = mod / 10;
                    int buckId = num / divBy;

                    bucket.putIfAbsent(buckId, new ArrayList<NumAndIter>());
                    ArrayList<NumAndIter> toNums = bucket.get(buckId);
                    toNums.add(new NumAndIter(numAndIter.num, iterCount));
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
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
        print(radix_sort(nums));
    }
}
