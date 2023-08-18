/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
https://leetcode.com/problems/palindrome-partitioning/
*/

package DynamicProgramming.MatrixChainMultiplication;
import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(s.toCharArray(),res,0,new ArrayList<String>());
        return res;
    }

    private void partition(char[] s, List<List<String>> res, int idx,ArrayList<String> list)
    {
        if(idx == s.length)                           //[1]
        {
            res.add(new ArrayList<String>(list));
        }

        for(int i=idx;i<s.length;i++)                 //[2]
        {
            if(isPalindrome(s,idx,i))
            {
                list.add(String.valueOf(s,idx,i-idx+1));
                partition(s,res,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    //checking for palindrome
    private boolean isPalindrome(char[] s,int i,int j){
        while(i<j)
        {
            if(s[i++]!=s[j--])
                return false;
        }
        return true;
    }
}

/*
We have to break the given string such that each partition of it is a palindrome.
In worst case scenario, the no. of required partitions will be n-1, with every character being a partition.

The partition method is the entry point of the backtracking algorithm.

[1] if the current index idx is equal to the length of the string s, it means the entire string has been processed,
and a valid palindromic partitioning has been found. So, a copy of the list is added to the res list.

[2] within the loop, the isPalindrome method is called to check if the substring from index idx to i is a palindrome.
If it is a palindrome, the substring is added to the list, and the partition method is called recursively with the updated index i+1.
After the recursive call, the last element is removed from the list to backtrack and explore other possibilities.
*/
