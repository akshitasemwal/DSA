/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
https://leetcode.com/problems/combinations/description/
*/

package Backtracking;
import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    static void generateSubsets(int start, int n, List<Integer> current, List<List<Integer>> subsets, int k )
    {
        if( current.size() == k )                                             //[1]
        {
            subsets.add( new ArrayList<>(current));
            return;
        }
        for(int i = start; i<=n; i++)                                         //[2]
        {
            current.add(i);
            generateSubsets(i+1, n, current, subsets, k);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {                 //[3]
        List< List< Integer > > subsets = new ArrayList<>();
        generateSubsets(1, n, new ArrayList<>(), subsets, k);
        return subsets;
    }
}

/*
[1] this checks if the size of the current list is equal to 'k'.
If it is, it means the combination is complete, so it adds the current combination to the subsets list and returns.

[2] if the combination is not yet complete, the method proceeds to form the combination. It iterates from the current start to 'n'.
For each number 'i' in the range, it adds 'i' to the current list to form a partial combination
and makes a recursive call to generateSubsets with the updated current list, incrementing 'i' by 1.
This is to ensure that the next number in the combination is greater than the current one to avoid duplicate combinations.
After the recursive call, it removes the last element from the current list to backtrack and try the next number.
The process continues until all combinations of size 'k' are generated.

[3] finally, the combine method returns the list of all combinations, which is stored in the subsets list.
*/