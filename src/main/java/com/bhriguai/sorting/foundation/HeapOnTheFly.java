package com.bhriguai.sorting.foundation;

import com.bhriguai.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeapOnTheFly {
    //NOTE - Storing the heap begins from the index 1. Index 0 is not used, set to MIN ELEMENT.

    /* To build a max-heap in-place, traverse from the right most element, when an element with a child is found, heapify down
    * from that element.
    */

    /* For in-place sorting of a max-heap, swap the root with the last element. So max goes to the last. Consider the last element is removed.
    * The heap size reduces by 1. Heapify down.
    * Repeat the same till the heap's virtual size reduces to 1.
    */

    void heapifyUp(ArrayList<Integer> h, int i) {
        if (i <= 1) {
            return;
        }
        int pI = Math.floorDiv(i, 2);
        if (h.get(i) > h.get(pI)) {
            Collections.swap(h, i, pI);
            heapifyUp(h, pI);
        }
    }

    ArrayList<Integer> buildHeap(ArrayList<Integer> list) {
        //Use index from 1, not 0;
        ArrayList<Integer> h = new ArrayList<>();
        h.add(0, Integer.MIN_VALUE);
        for (int i = 0; i < list.size(); i++) {
            h.add(list.get(i));
            heapifyUp(h, i+1);
        }
        return h;
    }

    public static void main(String[] args) {
        //Utils.getNumbers(10);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(-5, 8, 9, 15, 11, 14, -13, 17, 20, 30));
        Utils.print("List", l);

        HeapOnTheFly h = new HeapOnTheFly();
        Utils.print("Heap", h.buildHeap(l));
    }


}
