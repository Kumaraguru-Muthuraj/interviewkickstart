package com.bhriguai.recursion.foundation;

import com.bhriguai.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutations {

    static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            ArrayList<Integer> perm = new ArrayList<>();
            perm.add(arr.get(0));
            ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();
            perms.add(perm);
            return perms;
        } else {
            ArrayList<ArrayList<Integer>> newPerms = new ArrayList<ArrayList<Integer>>();
            int s = arr.size();
            for (int i = 0; i < s; i++) {
                Collections.swap(arr, 0, i);
                ArrayList<ArrayList<Integer>> permsSoFar = helper(new ArrayList<>(arr.subList(1, s)));
                newPerms.addAll(permsSoFar);
                for (ArrayList<Integer> newPerm : newPerms) {
                    newPerm.add(0, arr.get(0));
                }
                Collections.swap(arr, 0, i);
            }
            return newPerms;
        }
    }


    static ArrayList<ArrayList<Integer>> helper2(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> perms = new ArrayList<>();
        int s = arr.size();
        for (int i = 0; i < s; i++) {
            Collections.swap(arr, 0, i);
            if (s == 1) {
                ArrayList<Integer> perm = new ArrayList<>();
                perm.add(arr.get(0));
                perms = new ArrayList<ArrayList<Integer>>();
                perms.add(perm);
            } else {
                perms = helper2(new ArrayList<>(arr.subList(1, s)));
                for (ArrayList<Integer> perm : perms) {
                    perm.add(0, arr.get(0));
                    Utils.print("", perm);
                }
            }
            Collections.swap(arr, 0, i);
        }
        return perms;
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        return helper(arr);
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> pms = get_permutations(l);
        for (ArrayList<Integer> p : pms) {
            Utils.print("", p);
        }
    }
}
