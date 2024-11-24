package com.bhriguai.sorting.foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    // https://cs.stackexchange.com/questions/11458/quicksort-partitioning-hoare-vs-lomuto
    /*
    Kumar's mistakes - I used the left most element as the pivot always. This was wrong and for the worst case,
    it took a lot of time and a few tests timed out.
    We must always randomly pick the pivot and swap with the first or last element and proceed.
    In the solution provided by IK, and others, they have used Lomuto's partitioning.
    I have used Hoare's partitioning. The above link is in favour of Hoare's.

    The solution provided by IK has an explicit stack built rather than recursion.
     */
    static void helper(ArrayList<Integer> arr, int s, int e) {
        if (s >= e) {
            return;
        }
        /* Note the index generation, it has to be from s to e. --> When Random function returns 0 to val,
        and is added, it should be (s, e)
        */
        int pI = new Random().nextInt(e - s + 1) + s;
        Collections.swap(arr, s, pI);
        int p = arr.get(s);

        int L = s + 1;
        int R = e;
        while (L <= R) {
            if (arr.get(L) < p) {
                L++;
            } else if (p < arr.get(R)) {
                R--;
            } else {
                Collections.swap(arr, L, R);
                L++;
                R--;
            }
        }
        Collections.swap(arr, s, R);

        helper(arr, s, R - 1);
        helper(arr, R + 1, e);
    }

    static ArrayList<Integer> quick_sort(ArrayList<Integer> arr) {
        helper(arr,0, arr.size() - 1);
        return arr;
    }

    static void print(ArrayList<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 7, 5, 3, 8, 6, 4, 2));
        //ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 23, 7, 33, 11, 0, 3, 7, 4, 8, 7));
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 0, 1, 2, 1, 0, 1, 2, 0, 0,9, 10, -5, -4));
        quick_sort(nums);
        print(nums);
    }

}
