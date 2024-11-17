package com.bhriguai.sorting.foundation;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(ArrayList<Integer> arr) {
        /* Kumar's weakness here was that in line number 12, I was acccessing the element
        before checking the index for < 0. Just changed it an it works.
         */
        for (int i = 0; i < arr.size() - 1;i++) {
            int elem = arr.get(i + 1);
            int k = i;
            for (;  k >= 0  && arr.get(k) > elem; k--) {
                arr.set(k + 1, arr.get(k));
            }
            arr.set(k + 1, elem);
        }

        print(arr);
    }

    static void swap(ArrayList<Integer> l, int i, int j) {
        Integer temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }

    static void print(ArrayList<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(34, 56, 45, 21, 13, 97, 64, 67, 27));
        insertionSort(nums);

    }

}
