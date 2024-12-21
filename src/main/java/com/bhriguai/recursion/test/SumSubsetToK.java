package com.bhriguai.recursion.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* generate all subsets. As you generate, find sum. If sum matches return.
*/
public class SumSubsetToK {
    //This works for positive numbers ONLY. If there is a mix of + and - numbers it won't work.
    static Boolean helper(ArrayList<Long> arr, int idx, Long targetBalance, Long K) {
        //k == arr[0]
        if (targetBalance.equals(0L)) {
            return true;
        } else {
            while (idx < arr.size() && arr.get(idx) > targetBalance) {
                idx++;
            }
            for (; idx < arr.size(); idx++) {
                targetBalance -= arr.get(idx);
                Boolean found = helper(arr, idx + 1, targetBalance, K);
                if (found) {
                    return true;
                }
                targetBalance = K;
            }
        }
        return false;
    }

    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        return helper(arr, 0, k, k);
    }

    public static void main(String[] args) {
        ArrayList<Long> l = new ArrayList<Long>(Arrays.asList(8L, 7L, 2L, 6L, 4L));
        System.out.println(check_if_sum_possible(l, 13L));
    }

}
