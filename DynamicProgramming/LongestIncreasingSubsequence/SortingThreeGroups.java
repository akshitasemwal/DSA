/*
You are given a 0-indexed integer array nums of length n.
The numbers from 0 to n - 1 are divided into three groups numbered from 1 to 3,
where number i belongs to group nums[i]. Notice that some groups may be empty.
You are allowed to perform this operation any number of times:
Pick number x and change its group. More formally, change nums[x] to any number from 1 to 3.
A new array res is constructed using the following procedure:
Sort the numbers in each group independently.
Append the elements of groups 1, 2, and 3 to res in this order.
Array nums is called a beautiful array if the constructed array res is sorted in non-decreasing order.
Return the minimum number of operations to make nums a beautiful array.
https://leetcode.com/problems/sorting-three-groups/description/
TC: O(n*n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class SortingThreeGroups {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 2, 1, 3, 3);
        System.out.println(minimumOperations(nums));
    }
    public static int minimumOperations(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i<=3; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(nums.get(j) == i)
                {
                    list.add(j);
                }
            }
        }
        System.out.println(list);
        for(int i = 1; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if( list.get(i) > list.get(j) )
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++)
        {
            max = Math.max(max, dp[i]);
        }
        return n - max;
    }
}

/*
In this problem, we have to group the indices of the array based on the number at a particular index.
Then we have to find the number of shifts required to arrange the indices in increasing format.
For eg: for array: [2,1,3,2,1],
                    0 1 2 3 4
1 -> 1, 4
2 -> 0, 3
3 -> 2
When arranged in an array, these indices do not form an increasing list of numbers.

This is when we apply LIS, to return the no. of elements that are not a part of the LIS.
We do this by subtracting the length of LIS from the total no. of elements(n), which gives the no. of elements(indices)
which are not in an increasing order.
*/