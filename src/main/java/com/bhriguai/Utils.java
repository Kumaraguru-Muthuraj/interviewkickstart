package com.bhriguai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static void print(String message, List<Integer> arr) {
        System.out.print(message + " - ");
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static List<Integer> getRandomNumbers(int cnt) {
        Random r = new Random();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            l.add(r.nextInt(cnt*2));
        }
        return l;
    }

    public static List<Integer> getNumbers(int cnt) {
        Random r = new Random();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            l.add(r.nextInt(cnt*2));
        }
        return l;
    }

    public static List<Integer> getSequentialNumbers(int cnt) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= cnt; i++) {
            l.add(i);
        }
        return l;
    }
}
