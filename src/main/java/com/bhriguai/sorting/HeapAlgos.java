package com.bhriguai.sorting;

public class HeapAlgos {
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
}
