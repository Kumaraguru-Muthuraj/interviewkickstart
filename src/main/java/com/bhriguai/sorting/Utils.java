package com.bhriguai.sorting;

import java.util.ArrayList;
import java.util.Random;

public class Utils {
    static void print(String message, ArrayList<Integer> arr) {
        System.out.print(message + " - ");
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    static ArrayList<Integer> getNumbers(int cnt) {
        Random r = new Random();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            l.add(r.nextInt(cnt));
        }
        return l;
    }
}
