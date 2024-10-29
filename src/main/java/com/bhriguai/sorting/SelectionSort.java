package com.bhriguai.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    static ArrayList<Integer> selection_sort(ArrayList<Integer> arr) {
        // Write your code here.
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            int minIdx = i;
            for (int k = i+1; k < len; k++) {
                if (arr.get(k) < arr.get(minIdx)) {
                    minIdx = k;
                }
            }
            //Swap
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);
        }
        return arr;
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            //int min = arr[i];
            int minIdx = i;
            for (int k = i+1 ; k < arr.length; k++) {
                if (arr[k] < arr[minIdx]) {
                    //min = arr[k];
                    minIdx = k;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private int[] getNumbers() {
        int[] numbers = new int[10];
        Random random = new Random();

        // Fill the array with random numbers between 1 and 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        return numbers;
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] numbers = ss.getNumbers(); //{34, 10, 45, 23, 12, 9, 6, 7, 2};
        //numbers is passed by value but the data that it points to is on heap, so it gets modified.
        ss.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(34, 10, 45, 23, 12, 9, 6, 7, 2));
        ArrayList<Integer> r = selection_sort(nums);
    }


}
