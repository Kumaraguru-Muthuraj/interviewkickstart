package com.bhriguai.recursion.foundation;

public class CountAllSubsets {
    /** Its basically, nCk = nC0 + nC1 + nC2 + ... + nCn.
     * n=1 -> 1C0 + 1C1 = 1 + 1 = 2
     * n=2 -> 2C0 + 2C1 + 2C2 = 1 + 2 + 1 = 4
     * n=3 -> 3C0 + 3C1 + 3C2 + 3C3 = 1 + 3 + 3 + 1 = 8
     * its 2^n or f(n) = 2 x f(n-1)
    */
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
