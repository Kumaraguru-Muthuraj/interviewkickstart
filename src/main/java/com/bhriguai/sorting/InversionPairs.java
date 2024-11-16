package com.bhriguai.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionPairs {
    /* Get all pairs of numbers from an unsorted array of numbers, where the index i < j and
    a[i] > a[j].
    During merge sort, the partitions need to be compared.
    in the left and right partitions, say l and r,
    for any given i & j, if l[i] > r[j], we can conclude that for all the i' > i, l[i'] > r[j].

    https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
    */
    //Mistake - Learning - the break in the function was missed out.
    static int getLeftGreaterCnt(ArrayList<Integer> lst, int l1, int h1,
                                                            int l2, int h2) {
        int cnt = 0;
        for (;l2 <= h2; l2++) {
            for (;l1 <= h1; l1++) {
                if (lst.get(l1) > lst.get(l2)) {
                    cnt += h1 - l1 + 1;
                    break;
                }
            }
        }
        return cnt;
    }

    static int partition(ArrayList<Integer> list, int l, int h) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        if (l < h) {
            int m = l + (h - l) / 2;
            c1 = partition(list, l, m);
            c2 = partition(list, m + 1, h);
            c3 = getLeftGreaterCnt(list, l, m, m + 1, h);

            ArrayList<Integer> aux = new ArrayList<>();
            int i = l;
            int j = m + 1;
            while (i <= m && j <= h) {
                if (list.get(i) < list.get(j)) {
                    aux.add(list.get(i));
                    i++;
                } else {
                    aux.add(list.get(j));
                    j++;
                }
            }
            for (;i <= m; i++) {
                aux.add(list.get(i));
            }
            for (;j <= h; j++) {
                aux.add(list.get(j));
            }

            //Copy back.
            for (Integer k : aux) {
                list.set(l++, k);
            }
        }
        return c1 + c2 + c3;
    }

    static void inversionPairs(ArrayList<Integer> l) {
        int c = partition(l, 0, l.size() - 1);
        System.out.println("Count - " + c);
    }

    public static void main(String[] args) {
        //Utils.getNumbers(10);
        //new ArrayList<>(Arrays.asList(-5, 8, 9, 15, 11, 14, -13, 17, 20, 30));
        //new ArrayList<>(Arrays.asList(10, 9, 8, 12));
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(14, -13, 17, 20, 30, -5, 8, 9, 15, 11));
        Utils.print("List", l);
        inversionPairs(l);
        Utils.print("Sorted", l);
    }

}
