package com.bhriguai.sorting.live;

import com.bhriguai.sorting.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
In a list of integers, find the Kth largest.
Use bubble sort, max and min heap. Observe.
Then use Quick Sort.

Note that in this algorithm, the partitioning will reduce to smaller ranges.
Also we don't need to recurse. Not even an explicit stack.
We can do simple iteration and change the s and e indices.

Write an iterative version soon.
 */


public class FindKthLargest {
    /*Return the index of the element that found its home.
    When index is returned, check if it's (size-k)
    */
    static int KTH_IDX = Integer.MIN_VALUE;
    static int partition(ArrayList<Integer> lst, int s, int e) {
        Random r = new Random();
        int pI = s + r.nextInt(e - s + 1);
        int pV = lst.get(pI);
        Collections.swap(lst, pI, s);
        int lo = s + 1;
        int hi = e;
        while (lo <= hi) {
            if (lst.get(lo) < pV) {
                lo++;
            } else if (lst.get(hi) > pV) {
                hi--;
            } else {
                Collections.swap(lst, lo, hi);
                lo++;
                hi--;
            }
        }
        Collections.swap(lst, s, hi);
        int newPI = hi;
        if (newPI == KTH_IDX) {
            return KTH_IDX;
        } else if (newPI < KTH_IDX) {
            return partition(lst, newPI + 1, e);
        } else {
            return partition(lst, s, newPI - 1);
        }
    }
    // Get (size - k) index.
    static int getIndexOfKthLargest(ArrayList<Integer> l, int k) {
        if (0 <= k && k <= l.size()) {
            KTH_IDX = l.size() - k;
            int i = partition(l, 0, l.size() - 1);
            return l.get(i);
        }
        throw new RuntimeException("Invalid argument");
    }

    public static void main(String[] args) {
        //Utils.getNumbers(10);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 13, 10, 8, 7, 1, 0, 11));
        Utils.print("List", l);
        System.out.println(getIndexOfKthLargest(l, 3));
        Collections.sort(l);
        Utils.print("Sorted", l);
    }

}
