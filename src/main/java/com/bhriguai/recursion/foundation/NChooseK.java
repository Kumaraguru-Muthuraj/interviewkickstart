package com.bhriguai.recursion.foundation;

import com.bhriguai.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Given two integers n and k, find all the possible unique
combinations of k numbers in range 1 to n.

Example One
{
"n": 5,
"k": 2
}
Output:

[
[1, 2],
[1, 3],
[1, 4],
[1, 5],
[2, 3],
[2, 4],
[2, 5],
[3, 4],
[3, 5],
[4, 5]
]

Let us try to break this down into smaller problems. What if we needed the combinations of size 2 (that is, k = 2)? In this case,
we could have run two nested loops to generate all the unique combinations. Similarly, if we had k = 3, we could have run 3 nested
loops and so on. But since k is dynamic, we do not know beforehand how many nested loops to run. Therefore, this iterative solution
is not possible here. We have n numbers in range 1 to n. Being at any number, we can consider two possibilities of either including
or excluding it in the current combination.

Say we are at number current_number, we will have two possible cases as follows:

We will find the combinations of size k - 1 of numbers in range [current_number + 1, n] and will include the current numbers in all
such combinations to make them of size k. We will exclude the current_number and find the combinations of size k of number in
range [current_number + 1, n]. Performing this recursively for all the numbers in the range, we will be able to generate all the unique
combinations required. So, being at any number current_number, we will ask the recursion to get us all the unique combinations of size k - 1
and size k in range current_number + 1 to n. Let us understand this with an example. Say we have n = 5 and k = 2. Currently, we are at the
number current_number = 1. Now as stated above, we have to consider two possibilities of either including or excluding it. The combinations
of size k - 1 = 1 in range 2 to 5 are: [2], [3], [4], [5]. Including current_number = 1 in all these combinations, we get: [1, 2], [1, 3], [1, 4], [1, 5].
Similarly, the combinations of size k = 2 in range 2 to 5 are: [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5]. Together these
form all the combinations of size 2 in range from 1 to 5: [1, 2], [1, 3], [1, 4], [1, 5], [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5].

Time Complexity
O(2^n * n).

The total number of combinations = nCk.
To push nCk combination each of size k, we will require O(nC1 * 1 + nC2 * 2 + . . . + nCk * k) = O(n * 2^k) time in total.
And k can be equal to n. Thus, the time complexity will be O(2^n * n).

Auxiliary Space Used
O(n).
It is the worst case recursion depth.

Space Complexity
O(nCk * k).
The total space complexity is dominated by the size of output.

recursive_solution (Java)
static void combinations_recursive(int current_number, int n, int k, ArrayList<Integer> current,
                                        ArrayList<ArrayList<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (current_number == n + 1) {
            return;
        }

        current.add(current_number);
        combinations_recursive(current_number + 1, n, k, current, result);
        current.remove(current.size() - 1);
        combinations_recursive(current_number + 1, n, k, current, result);
    }

    static ArrayList<ArrayList<Integer>> find_combinations(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        combinations_recursive(1, n, k, current, result);
        return result;
    }

 */
public class NChooseK {
    static void NChooseKHelper(List<List<Integer>> solutions, List<Integer> slate, int start, int n, int k) {
        if (slate.size() == k) {
            ArrayList<Integer> soln = new ArrayList<>(Collections.nCopies(k, 0));
            Collections.copy(soln, slate);
            solutions.add(soln);
        } else {
            //It should be start <= n-k+1
            for (;start <= n; start++) {
                slate.add(start);
                NChooseKHelper(solutions, slate, start+1, n, k);
                slate.remove(slate.size() - 1);
            }
        }
    }

    static List<List<Integer>> find_combinations(Integer n, Integer k) {
        List<List<Integer>> sols = new ArrayList();
        NChooseKHelper(sols, new ArrayList<Integer>(), 1, n, k);
        return sols;
    }

    public static void main(String[] args){
        List<List<Integer>> sols = find_combinations(5,2);
        for (List<Integer> s : sols) {
            Utils.print("", s);
        }
    }

}
