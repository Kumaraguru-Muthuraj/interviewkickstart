package com.bhriguai.sorting;

import java.util.*;

public class HeapSort {
    /*
    The heapify operation should be called from n/2 index downwards, because the items from n/2 + 1 don't have children.
    Heapify should be iterative.
    Infact any recursive should be done iteratively.
     */

    int getMaxIdxOfChild(ArrayList<Integer> h, int i, int size) {
        int lI = i * 2;
        int rI = lI + 1;
        if (lI >= size) {
            return Integer.MIN_VALUE;
        }
        if (rI < size && h.get(rI) > h.get(lI)) {
            return rI;
        }
        return lI;
    }

    void heapifyDownWithVirtualMax(ArrayList<Integer> h, int i, int size) {
        int mI = getMaxIdxOfChild(h, i, size);
        if (mI <= 0) {
            return;
        }
        // BE SURE THAT THE HEAPIFY IS CALLED ON THE CHILD
        if (h.get(mI) > h.get(i)) {
            Collections.swap(h, mI, i);
            heapifyDownWithVirtualMax(h, mI, size);
        }
    }

    ArrayList<Integer> buildHeap(ArrayList<Integer> list) {
        //NOTE - Storing the heap begins from the index 1. Index 0 is not used, set to MIN ELEMENT.
        list.add(0, Integer.MIN_VALUE);
        for (int i = list.size() - 1; i > 0; i--) {
            heapifyDownWithVirtualMax(list, i, list.size());
        }
        return list;
    }

    void heap_sort(ArrayList<Integer> h) {
        buildHeap(h);

        int size = h.size();
        for (int idx = size - 1; idx > 1; idx--) {
            Collections.swap(h, 1, idx);
            heapifyDownWithVirtualMax(h, 1, idx);
        }
        h.remove(0);
    }

    public static void main(String[] args) {
        //Utils.getNumbers(10);
        ArrayList<Integer> l = Utils.getNumbers(20);//new ArrayList<>(Arrays.asList(-5, 8, 9, 15, 11, 14, -13, 17, 20, 30));
        Utils.print(l);

        HeapSort h = new HeapSort();
        //h.buildHeap(l);
        h.heap_sort(l);
        Utils.print(l);

        System.out.println("************");

    }


}
