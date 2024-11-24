package com.bhriguai.recursion.foundation;

public class CountAllSubsets {
    static Integer count_all_subsets(Integer n) {
        if (n < 1) return 1;
        if (n == 1) {
            return 2;
        } else {
            return 2 * count_all_subsets(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(count_all_subsets(2));
    }
}
