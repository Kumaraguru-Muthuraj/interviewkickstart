package com.bhriguai.sorting.foundation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.bhriguai.sorting.foundation.QuickSort.print;

public class CountingSort {
    /*
    * Instead of adding the elements in the hashtable, you can maintain a count and hence it becomes Hash<Integer, Integer>
    * Later when you want to created the sorted array, you can add as many as the count says.
    * Tradeoff - The implementation here will produce a stable sort, where as counting will not produce.
     */
    static ArrayList<Integer> counting_sort(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, ArrayList<Integer>> bucket = new HashMap<>();
        for (Integer i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            bucket.putIfAbsent(i, new ArrayList<>());
            ArrayList<Integer> nums = bucket.get(i);
            nums.add(i);
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ArrayList<Integer> nums = bucket.get(i);
            if (nums != null) {
                sorted.addAll(nums);
            }
        }
        return sorted;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(30, 7, 23, 30, 7, 23, 5, 30, 5, -100, -200, -100, -1000, 6,
                        23, 7, 6, 3, -999,2, 9, 10, 9, 10, 9, 10, 6, 5, 3, 2));
        print(counting_sort(nums));
    }
}
