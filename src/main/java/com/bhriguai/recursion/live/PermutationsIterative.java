package com.bhriguai.recursion.live;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationsIterative {

    /*
    Asymptotic complexity in terms of `n` =  size of the input array:
    * Time: O(n * n!).
    * Auxiliary space: O(n).
    * Total space: O(n * n!).
    */

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        if (arr.size() > 0) ans.add(arr); // Add the first permutation to ans

        while (true) {
            ArrayList<Integer> cloned_arr = new ArrayList<>(arr);
            boolean next_permutation_present = next_permutation(cloned_arr);
            if (!next_permutation_present) {
                return ans;
            } else {
                ans.add(cloned_arr);
                arr = cloned_arr;
            }
        }
    }

    /*
    - [5, 4, 3, 2, 1] returns false because the next permutation is not possible.
    - [3, 2, 5, 4, 1] modifies arr to be [3, 4, 1, 2, 5] and returns true as the next permutation is
    - possible.
    */
    static boolean next_permutation(ArrayList<Integer> arr) {
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i + 1) <= arr.get(i)) {
            i--;
        }
        if (i >= 0) {
            int j = arr.size() - 1;
            // Find the smallest number greater than arr.get(i)
            while (j >= 0 && arr.get(j) <= arr.get(i)) {
                j--;
            }
            swap(arr, i, j);
            reverse(arr, i + 1);
            return true;
        }
        return false;
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    static void reverse(ArrayList<Integer> arr, int start) {
        int i = start, j = arr.size() - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}

