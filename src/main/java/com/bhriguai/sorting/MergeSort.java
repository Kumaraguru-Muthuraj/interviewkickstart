package com.bhriguai.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {


    static void helper(ArrayList<Integer> arr, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            helper(arr, l, m);
            helper(arr, m + 1, h);

            ArrayList<Integer> aux = new ArrayList<>();
            int i = l;
            int j = m+1;
            while (i <= m && j <= h) {
                if (arr.get(i) < arr.get(j)) {
                    aux.add(arr.get(i));
                    i++;
                } else {
                    aux.add(arr.get(j));
                    j++;
                }
            }
            // BUG - Earlier I thought that only 1 element is left and there was a bug.
            // You have to copy all of the left out elements in either of the partition.
            for (; i <= m; i++) {
                aux.add(arr.get(i));
            }
            for (; j <= h; j++) {
                aux.add(arr.get(j));
            }
            //Copy back
            for (int k = 0; k < aux.size(); k++, l++) {
                arr.set(l, aux.get(k));
            }
        }
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        // Write your code here.
        helper(arr, 0, arr.size() - 1);
        return arr;
    }

    static void print(ArrayList<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 7, 5, 3, 8, 6, 4, 2));
        merge_sort(nums);
        print(nums);
    }

}
