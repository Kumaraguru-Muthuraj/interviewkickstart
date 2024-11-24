package com.bhriguai.sorting.problems;

/*
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra.
Dutch national flag has three colors (albeit different from ones used in this problem).
 */
/*
Read page number 65 of EPI. Quick Sort might be expensive. To make it cheap, we get the pivot elements in the middle, before sorting.
This is called the Dutch national flag (or Russian, etc).
In this problem, we will not sort the list completely, but move the elements less than pivot to the left and right otherwise.
To simplify, we will have elements with 3 colors and they need to be segregated.
 */

import com.bhriguai.Utils;

import java.util.*;

/*
At any arbitrary iteration, the list would look like this.
[ 0, 1,  2,   3, 4, 5, 6, 7, 8,  9, 10, 11, 12] <--- Index.
[-1, 0, -8, -10, 2, 2, *, *, *, 10,  5,  7,  3] <--- Elements.
Pivot = 2;
- Elements (0, 3) are less than the pivot 2.
- Elements (4, 5) have the pivot.
- Elements (9, 12) are greater than pivot.
- We want to solve for (6, 8), we don't know what values are there.
As a human you would do the following:
1) If a[6] can have either 2, or < 2 or > 2.
2) If 2, we move to the next element, a[7]. So we need a pointer for this, say 'eq'.
3) If a[6] < 2 -> swap(a[4], a[6]). So we need another pointer to the beginning of the zone of pivot elements. Call this 'l'. After swap, l++, eq++;
4) If a[6] > 2 -> swap(a[6], a[9]). We need a third pointer 'h' to point to the last element higher than 2. After swap, h--;
5) Do this until e < h;
 */
public class DutchNationalFlag {
    //From IK
    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        int n = balls.size();

        // When we will encounter any red ball, we will swap it with character present at this index.
        int swap_red_here = 0;

        // Position we are processing currently.
        int current_idx = 0;

        // When we will encounter any blue ball, we will swap it with character present at this index.
        int swap_blue_here = n - 1;

        // Continue till we have sorted all the balls.
        while (current_idx <= swap_blue_here) {
            if (balls.get(current_idx) == 'R') {
                char temp = balls.get(current_idx);
                balls.set(current_idx, balls.get(swap_red_here));
                balls.set(swap_red_here, temp);
                swap_red_here++;
                current_idx++;
            }
            else if (balls.get(current_idx) == 'G') {
                current_idx++;
            }
            else {
                char temp = balls.get(current_idx);
                balls.set(current_idx, balls.get(swap_blue_here));
                balls.set(swap_blue_here, temp);
                swap_blue_here--;
            }
        }
        return balls;
    }
    /*
    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        // Write your code here.
        return new ArrayList();
    }*/
    enum Color {
        R,
        G,
        B
    }

    static List<Color> dutchFlag(List<Color> colors, Color p) {
        int l = 0;
        int e = 0;
        int h = colors.size() - 1;
        while (e <= h) {
            if (colors.get(e).ordinal() == p.ordinal()) {
                e++;
            } else if (colors.get(e).ordinal() < p.ordinal()) {
                Collections.swap(colors, l++, e++);
            } else {
                Collections.swap(colors, h--, e);
            }
        }
        return colors;
    }

    static List<Character> dutch_flag_sort(List<Character> balls) {
        List<Color> l = new ArrayList<>();
        for (Character c : balls) {
            l.add(Color.valueOf(c.toString()));
        }
        dutchFlag(l, Color.G);
        List<Character> cl = new ArrayList<>();
        for (Color c : l) {
            cl.add(c.toString().toCharArray()[0]);
        }
        return cl;
    }

    public static void main(String[] args) {
       // dutch_flag_sort(Arrays.asList('B', 'R', 'G', 'G'));
        /////
        List<Color> l = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            l.add(Color.values()[r.nextInt(3)]);
        }
        //l.clear();
        //l = Arrays.asList(Color.B, Color.R, Color.G, Color.G);
        System.out.println(l);
        System.out.println("");
        dutchFlag(l, Color.G);
        System.out.println(l);
    }


}
