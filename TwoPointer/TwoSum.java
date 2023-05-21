/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
TC: O(n)
SC: O(1)
https://leetcode.com/problems/two-sum/description/
*/

package TwoPointer;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }


    static class Pair {
        int idx, val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void twoSum(int[] nums, int target) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) pairs[i] = new Pair(i, nums[i]);
        Arrays.sort(pairs, Comparator.comparingInt(o -> o.val));
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = pairs[l].val + pairs[r].val;
            if (sum == target) {
                return new int[]{ pairs[l].idx, pairs[r].idx };
            } else if (sum < target) l++;
            else r--;
        }
        System.out.print(pairs[0]+" "+pairs[1]);
    }
}
