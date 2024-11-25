package com.bhriguai.sorting.problems;

import com.bhriguai.Utils;

import java.util.Collections;
import java.util.List;

public class SegregateEvenOdd {

    static List<Integer> segregate_evens_and_odds(List<Integer> numbers) {
        int l = 0;
        int h = numbers.size() - 1;
        // left is even, right is odd.
        while (l <= h) {
            if (numbers.get(l) % 2 == 0) {
                l++;
            } else if (numbers.get(h) % 2 != 0) {
                h--;
            } else {
                Collections.swap(numbers, l++ , h--);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> l = Utils.getNumbers(10);
        Utils.print("Before", l);
        segregate_evens_and_odds(l);
        Utils.print("Segregated", l);
    }

}
