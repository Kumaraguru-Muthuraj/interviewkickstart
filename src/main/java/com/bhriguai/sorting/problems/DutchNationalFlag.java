package com.bhriguai.sorting.problems;

/*
Read page number 65 of EPI. Quick Sort might be expensive. To make it cheap, we get the pivot elements in the middle, before sorting.
This is called the Dutch national flag (or Russian, etc).
In this problem, we will not sort the list completely, but move the elements less than pivot to the left and right otherwise.
To simplify, we will have elements with 3 colors and they need to be segregated.
 */

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

}
