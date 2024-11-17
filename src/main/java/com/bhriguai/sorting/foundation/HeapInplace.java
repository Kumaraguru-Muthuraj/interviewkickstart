package com.bhriguai.sorting;

import java.util.*;

public class HeapInplace {
    //NOTE - Storing the heap begins from the index 1. Index 0 is not used, set to MIN ELEMENT.

    /* To build a max-heap in-place, traverse from the right most element, when an element with a child is found, heapify down
    * from that element.
    */

    /* For in-place sorting of a max-heap, swap the root with the last element. So max goes to the last. Consider the last element is removed.
    * The heap size reduces by 1. Heapify down.
    * Repeat the same till the heap's virtual size reduces to 1.
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

    void testPriorityQueue(ArrayList<Integer> list) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(c);
        pq.addAll(list);

        for (Integer integer : pq) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = Utils.getNumbers(10);//new ArrayList<>(Arrays.asList(-5, 8, 9, 15, 11, 14, -13, 17, 20, 30));
        Utils.print("List", l);

        HeapInplace h = new HeapInplace();
        h.testPriorityQueue(l);

        h.buildHeap(l);
        Utils.print("Heap", l);

    }


}
