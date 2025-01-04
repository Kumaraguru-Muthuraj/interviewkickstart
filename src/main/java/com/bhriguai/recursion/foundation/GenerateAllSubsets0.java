package com.bhriguai.recursion.foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubsets0 {
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

    static ArrayList<String> list;
    static ArrayList<String> generateSubsets2(String slate, List<Character> lst) {
        if (lst.size() == 0) {
            list.add(slate);
        } else {
            generateSubsets2(slate, lst.subList(1, lst.size()));
            generateSubsets2(slate + lst.get(0), lst.subList(1, lst.size()));
        }
        return list;
    }

    static ArrayList<String> generate_all_subsets(String s) {
        list = new ArrayList<>();
        ArrayList<Character> C = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            C.add(c);
        }
        return generateSubsets2("", C);
    }

    public static void main(String[] args) {
        Character a[]
                = new Character[] { 'x', '2', '3'};
        //printSubsets(Arrays.asList(a));
        ArrayList<String> l = generate_all_subsets("1234");
        for (String s : l) {
            System.out.println("S - " + s);
        }
    }
}
