package com.bhriguai.sorting.live;

public class SumPairs {
    /* Given an array arr[] of n integers and a target value, the task is to find the number of pairs of integers in the array whose sum is equal to target.
    The idea is to sort the input array and use two-pointer technique. Maintain two pointers, say left and right and initialize them to the first and last
    element of the array respectively. According to the sum of left and right pointers, we can have three cases:

    arr[left] + arr[right] < target: Increase the pair sum by moving the left pointer towards right.
    arr[left] + arr[right] > target: Decrease the pair sum by moving the right pointer towards left.
    arr[left] + arr[right] = target: We have found a pair whose sum is equal to target. We can find the product of the count of both the elements and add them to the result.
    https://www.geeksforgeeks.org/count-pairs-with-given-sum/

    HashTable approach.
    HashMap or Dictionary provides a more efficient solution to the 2Sum problem. Instead of checking every pair of numbers, we keep each number
    in a map as we go through the array. For each number, we calculate its complement (i.e., target – current number) and check if it’s in the map.
    If it is, increment the count variable by the occurrences of complement in map.

    */


}
