package com.bhriguai.recursion;

public class Fibonacci {
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib (n - 1) + fib(n -2);
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int f = 0;
        int p1 = 0;
        int p2 = 1;
        while (n-- >= 2) {
            f = p1 + p2;
            p1 = p2;
            p2 = f;
        }
        return f;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib2(i));
        }
    }

}
