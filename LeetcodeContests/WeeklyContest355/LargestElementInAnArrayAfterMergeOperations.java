/*
You are given a 0-indexed array nums consisting of positive integers.
You can do the following operation on the array any number of times:
Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1].
Replace the element nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
Return the value of the largest element that you can possibly obtain in the final array.
https://leetcode.com/contest/weekly-contest-355/problems/largest-element-in-an-array-after-merge-operations/
*/

package LeetcodeContests.WeeklyContest355;
import java.util.*;

public class LargestElementInAnArrayAfterMergeOperations {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 9, 3};
        System.out.println(maxArrayValue(nums));
    }

    public static long maxArrayValue(int[] nums) {
        int n = nums.length;

        Stack<Long> s = new Stack<>();
        s.add((long)nums[n-1]);

        long ans = nums[n-1];                            //[1]
        for(int i = n-2; i >= 0; i--)                    //Start iterating the array from the second last element (index n-2) to the first element (index 0).
        {
            long curr = nums[i];                         //Store the current element
            long poppedElement = 0;
            if(!s.isEmpty())                             //[2]
            {
                poppedElement = s.pop();
                poppedElement = poppedElement >= curr ? poppedElement:0;
            }
            s.add((long)(curr + poppedElement));         //[3]
            ans = Math.max(ans, Math.max(curr, s.isEmpty()?0:s.peek()));   //[4]
        }
        return ans;
    }
}

/*
[1] ans is initialized with last element of the array since there cannot be any element after it which needs to be compared.

[2] if the stack s is not empty, pop the top element of the stack and store it in the variable poppedElement.
Compare the poppedElement with the curr. If poppedElement is greater than or equal to curr,
keep poppedElement as it is; otherwise, set poppedElement to 0.
This step simulates the merge operation by taking the maximum of the current element and the top of the stack.

[3] add the merged value of curr + poppedElement to the stack s using s.add((long)(curr + poppedElement)).

[4] Update the ans by taking the maximum of ans, curr, and the top of the stack (if the stack is not empty)
using ans = Math.max(ans, Math.max(curr, s.isEmpty()? 0 : s.peek())).
*/
