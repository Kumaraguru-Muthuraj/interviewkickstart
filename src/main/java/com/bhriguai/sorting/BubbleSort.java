package com.bhriguai.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    static ArrayList<Integer> bubble_sort(ArrayList<Integer> arr) {
        int len = arr.size();
        for (int i = 0; i < len-1; i++) {
            for (int s = len - 1; s > i; s--) {
                if (arr.get(s) < arr.get(s - 1)) {
                    swap(arr, s, s - 1);
                }
            }
        }
        return arr;
    }

    static void swap(ArrayList<Integer> l, int i, int j) {
        Integer temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(34, 10, 45, 23, 12, 9, 6, 7, 2));
        bubble_sort(nums);

    }

}
