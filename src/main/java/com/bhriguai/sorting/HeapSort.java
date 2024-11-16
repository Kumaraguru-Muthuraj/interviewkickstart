package com.bhriguai.sorting;

import java.util.*;

public class HeapSort {

    int getMaxIdxOfChild(ArrayList<Integer> h, int i) {
        int lI = i * 2;
        int rI = lI + 1;
        if (lI >= h.size()) {
            return Integer.MIN_VALUE;
        }
        if (rI < h.size() && h.get(rI) > h.get(lI)) {
            return rI;
        }
        return lI;
    }
    void heapifyDown(ArrayList<Integer> h, int i) {
        int mI = getMaxIdxOfChild(h, i);
        if (mI <= 0) {
            return;
        }
        // BE SURE THAT THE HEAPIFY IS CALLED ON THE CHILD
        if (h.get(mI) > h.get(i)) {
            Collections.swap(h, mI, i);
            heapifyDown(h, mI);
        }
    }

    ArrayList<Integer> buildHeap(ArrayList<Integer> list) {
        //NOTE - Storing the heap begins from the index 1. Index 0 is not used, set to MIN ELEMENT.
        list.add(0, Integer.MIN_VALUE);
        for (int i = list.size() - 1; i > 0; i--) {
            heapifyDown(list, i);
        }
        return list;
    }
    void sort() {

    }

    public static void main(String[] args) {
        //Utils.getNumbers(10);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(-5, 8, 9, 15, 11, 14, -13, 17, 20, 30));
        Utils.print(l);

        HeapSort h = new HeapSort();
        h.buildHeap(l);
        h.sort();
        Utils.print(l);

        System.out.println("************");

    }


}
