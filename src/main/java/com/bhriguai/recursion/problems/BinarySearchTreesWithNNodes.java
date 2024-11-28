package com.bhriguai.recursion.problems;

/*
Write a function that returns the number of distinct binary search trees that can be constructed with n nodes.
For the purpose of this exercise, do solve the problem using recursion first even if you see some non-recursive approaches.
 */
public class BinarySearchTreesWithNNodes {
     /*
    Asymptotic complexity in terms of `n`:
    * Time: O(Catalan number(n)).
    * Auxiliary space: O(n).
    * Total space: O(n).
    */

    static Long how_many_bsts(Integer n) {
        if (n <= 1) {
            return 1L;
        } else if (n == 2){
            return 2L;
        } else {
            Long c = 0L;
            for (int i = 1; i <= n ; i++) {
                c += how_many_bsts(i - 1) * how_many_bsts(n - i);
            }
            return c;
        }
    }

    /*
    Asymptotic complexity in terms of `n`:
    * Time: O(n).
    * Auxiliary space: O(1).
    * Total space: O(1).
    */

    static Long n_choose_r(Long n, Long r) {
        // n choose r = n choose (n - r) property. Like 5 Choose 2 = 10 = 5 Choose 3.
        if (r > n - r) {
            r = n - r;
        }
        // n choose r = [n * (n - 1) * --- * (n - r + 1)] / [r * (r - 1) * --- * 1].
        Long nCr = 1L;
        for (Long i = 0L; i < r; i++) {
            nCr *= (n - i);
            nCr /= (i + 1L);
        }
        return nCr;
    }

    static Long how_many_bsts2(Integer n) {
        // Value of nth Catalan number = (2n Choose n) / (n + 1)
        Long two_n_choose_n = n_choose_r((long)n*2, (long)n);
        return two_n_choose_n / ((long)n + 1L);
    }

    public static void main(String[] args) {
        System.out.println(how_many_bsts2(5));
    }

}
