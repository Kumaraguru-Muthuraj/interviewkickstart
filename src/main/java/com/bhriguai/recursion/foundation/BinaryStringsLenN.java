package com.bhriguai.recursion.foundation;

import java.util.ArrayList;

public class BinaryStringsLenN {

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

    public static void main(String[] args) {
       ArrayList<String> perms = genBinary1(15);
       for (String p : perms) {
           System.out.println(p);
       }
    }
}
