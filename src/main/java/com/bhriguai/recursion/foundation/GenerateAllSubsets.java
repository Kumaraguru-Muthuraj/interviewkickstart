package com.bhriguai.recursion.foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubsets {
    static void printSubsets(List<Character> lst) {
        generateSubsets("", lst);
    }

    static void generateSubsets(String slate, List<Character> lst) {
        if (lst.size() == 0) {
            System.out.println(slate);
        } else {
            generateSubsets(slate, lst.subList(1, lst.size()));
            generateSubsets(slate + lst.get(0), lst.subList(1, lst.size()));
        }
    }

    public static void main(String[] args) {
        Character a[]
                = new Character[] { '1', '2', '3'};
        printSubsets(Arrays.asList(a));

    }
}
