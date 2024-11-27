package com.bhriguai.recursion.live;

import com.bhriguai.Utils;
import jdk.jshell.execution.Util;

import java.lang.reflect.Array;
import java.util.*;

public class PermuteArrayOfUniqueIntegers {
    public static void permute(List<Integer> slate, List<Integer> l) {
        if (l.isEmpty()) {
            Utils.print("", slate);
        } else {
            int max = l.size();
            for (int i = 0; i < max; i++) {
                Integer addThis2Slate = l.get(i);
                slate.add(addThis2Slate);
                l.remove(i);
                permute(slate, l);
                l.add(i, addThis2Slate);
                slate.remove(slate.size() - 1);
            }
        }
    }

    public static void permute(ArrayList<ArrayList<Integer>> sols, ArrayList<Integer> slate, ArrayList<Integer> l) {
        if (l.isEmpty()) {
            ArrayList<Integer> sol = new ArrayList<>(Collections.nCopies(slate.size(), -1));
            Collections.copy(sol, slate);
            sols.add(sol);
        } else {
            int max = l.size();
            for (int i = 0; i < max; i++) {
                Integer addThis2Slate = l.get(i);
                slate.add(addThis2Slate);
                l.remove(i);
                permute(sols, slate, l);
                l.add(i, addThis2Slate);
                slate.remove(slate.size() - 1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        permute(sol, new ArrayList<Integer>(), arr);
        return sol;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Utils.print("All nos", l);
        ArrayList<ArrayList<Integer>> sols = get_permutations(l);
        for (ArrayList<Integer> sol : sols) {
            Utils.print("", sol);
        }
    }

    ///

    /*
    Asymptotic complexity in terms of `n` =  size of the input array:
    * Time: O(n * n!).
    * Auxiliary space: O(n).
    * Total space: O(n * n!).
    */
    static ArrayList<ArrayList<Integer>> get_permutations_IK(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        backtrack(arr, 0, ans);
        return ans;
    }

    static void backtrack(ArrayList<Integer> arr, int fixed_index, ArrayList<ArrayList<Integer>> ans) {
        // Base case
        if (fixed_index >= arr.size()) {
            // Create a new copy of arr and add to ans
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = fixed_index; i < arr.size(); i++) {
            swap(arr, fixed_index, i);
            backtrack(arr, fixed_index + 1, ans);
            // Re-swap to restore the original arr state
            swap(arr, fixed_index, i);
        }
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
