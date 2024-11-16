package com.bhriguai.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class HeapInplace {
    //NOTE - Storing the heap begins from the index 1. Index 0 is not used, set to MIN ELEMENT.

    /* To build a max-heap in-place, traverse from the right most element, when an element with a child is found, heapify down
    * from that element.
    */

    /* For in-place sorting of a max-heap, swap the root with the last element. So max goes to the last. Consider the last element is removed.
    * The heap size reduces by 1. Heapify down.
    * Repeat the same till the heap's virtual size reduces to 1.
    */

    /*
    * Sorting the max-heap in-place. Swap the root with the last element. So the last element found its place.
    * Reduce the heap size virtually by 1. Heapify from the root.
    */

    int getMaxIdx (ArrayList<Integer> list, int l, int r) {
        if (l >= list.size()) {
            return Integer.MIN_VALUE;
        }
        if (r < list.size() && list.get(l) < list.get(r)) {
            return r;
        }
        return l;
    }

    void heapifyDown(ArrayList<Integer> list, int rI) {
        int cI = getMaxIdx(list, rI * 2, rI * 2 + 1);
        if (cI <= 0) {
            return;
        }
        if (list.get(rI) < list.get(cI)) {
            Collections.swap(list, rI, cI);
            heapifyDown(list, cI);
        }
    }

    ArrayList<Integer> buildHeap(ArrayList<Integer> list) {
        //Use index from 1, not 0;
        list.add(0, Integer.MIN_VALUE);
        for (int idx = list.size() - 1; idx > 0; idx--) {
            heapifyDown(list, idx);
        }
        return list;
    }

    public static void main(String[] args) {
        //Utils.getNumbers(10);
        ArrayList<Integer> l = Utils.getNumbers(10);//new ArrayList<>(Arrays.asList(-5, 8, 9, 15, 11, 14, -13, 17, 20, 30));
        Utils.print(l);

        HeapInplace h = new HeapInplace();
        h.buildHeap(l);
        Utils.print(l);
    }


}
