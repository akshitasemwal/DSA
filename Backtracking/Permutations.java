/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
https://leetcode.com/problems/permutations/
TC: O(n! * n)
SC: O(n)
*/

package Backtracking;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums)  //helper function
    {
        if( tempList.size() == nums.length )                     //[1]
        {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int num : nums)                                      //[2]
        {
            if(tempList.contains(num))
            {
                continue;
            }
            tempList.add(num);
            backtrack(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        backtrack( res, new ArrayList<>(), nums);               //[3]
        return res;
    }
}

/*
Permutation of an array would mean arranging the numbers in an array in every possible manner.
Since it uses the same repetitive concept of choosing a number from the array, setting it as fixed, and then arranging the remaining numbers.
Then choosing another number from the remaining numbers, and setting it with the previously chosen number, and arranging the remaining numbers.
This entire process is carried out for each number, and forms a tree like structure, which is similar to a recursive tree.

[1] the base case of this function is that when the size of the new tempList is equal to the desired size,
the list will be added to the result list and the function will be returned. It will mean that the permutation has been made.

[2] iterate through the entire given array. If the current number is already present in the tempList, then that number can be skipped.
Otherwise, that number is added to the tempList.
The recursive call is made to go back and try for the next element.
The res list, tempList containing the set number, and the given array are passed as parameters.

[3] the first recursive call is made, and an empty list is sent to start.
*/