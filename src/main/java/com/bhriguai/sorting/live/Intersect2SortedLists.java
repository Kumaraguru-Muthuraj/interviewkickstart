package com.bhriguai.sorting.live;

import com.bhriguai.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Remove duplicates needs handling.

public class Intersect2SortedLists {
    public static List<Integer> intersection(List<Integer> l1, List<Integer> l2) {
        List<Integer> itr = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            if (l1.get(p1) < l2.get(p2)) {
                p1++;
            } else if (l2.get(p2) < l1.get(p1)) {
                p2++;
            } else {
                itr.add(l1.get(p1));
                p1++;
                p2++;
            }
        }
        return itr;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Utils.getNumbers(6);
        Collections.sort(l1);
        List<Integer> l2 = Utils.getNumbers(8);
        Collections.sort(l2);
        Utils.print("L1", l1);
        Utils.print("L2", l2);
        List<Integer> itr = intersection(l1, l2);
        Utils.print("Intr", itr);
    }

}
