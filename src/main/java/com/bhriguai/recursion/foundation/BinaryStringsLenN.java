package com.bhriguai.recursion.foundation;

import java.util.ArrayList;

public class BinaryStringsLenN {
    // High space complexity
    static ArrayList<String> genBinary1(int n) {
        if (n == 1) {
            ArrayList<String> l = new ArrayList<>();
            l.add("0");
            l.add("1");
            return l;
        }
        ArrayList<String> curr = new ArrayList<>();
        ArrayList<String> prev = genBinary1(n-1);
        for (String perm : prev) {
            curr.add(perm + "0");
            curr.add(perm + "1");
        }
        return curr;
    }

    // O(n) space complexity
    static void binaryHelper(int n, String slate) {
        if (n == 0) {
            System.out.println(slate);
        } else {
            binaryHelper(n-1, slate + "0");
            binaryHelper(n-1, slate + "1");
        }
    }

    static void getBinary2(int n) {
        binaryHelper(n, "");
    }

    public static void main(String[] args) {
        getBinary2(5);
       /*ArrayList<String> perms = genBinary1(15);
       for (String p : perms) {
           System.out.println(p);
       }*/
    }
}
