/*
You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.
https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int r = n - 1;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( letters[mid] <= target )            //[1]
            {
                l = mid + 1;
            }
            else                                    //[2]
            {
                r = mid - 1;
            }
        }
        return letters[l % n];                      //[3]
    }
}

/*
Since this solution requires us to return the smallest letter greater than target,
we can use the concept of upper bound to return the element.

[1] if target is less greater than or equal to mid,
l can be updated since all the characters to the left will obviously be smaller than target.
l is also a candidate for upperbound. When l > r, l contains the upper bound.

[2] if the target is less than the mid element,
the right side can obviously be neglected since all the other characters will also be greater than target.

[3] since l contains the upper bound, it is returned. In case of a circular array,
if l becomes greater than the last index of the array (n - 1),
taking the modulus by n brings it back to a valid index within the array.
*/