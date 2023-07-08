/*
You are given a sorted array consisting of only integers where every element appears exactly twice,
except for one element which appears exactly once.
Return the single element that appears only once.
https://leetcode.com/problems/single-element-in-a-sorted-array/
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int l = 0;
        int r = n - 1;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if ( ( mid + 1 <= n - 1 ) && nums[mid] == nums[mid + 1] )         //[1]
            {
                if( mid % 2 == 0 )
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            else if ( ( mid - 1 >= 0 ) && nums[mid] == nums[mid - 1] )        //[2]
            {
                if( mid % 2 != 0 )
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            else
            {
                return nums[mid];
            }
        }
        return - 1;
    }
}

/*
We observe that before the occurrence of single element,
the first occurrence of any element is at even index, and its second occurrence is at an odd index.
After the single element's occurrence, it gets switched and now the first occurrence is at odd index and second occurrence at even index.

We know that at a certain index, the element can either be a first occurrence, a second occurrence or the single element.

[1] this condition checks if the nums[mid] is the first occurrence or not, by checking if the element to its right is the same.
We also check if ( mid + 1 ) <= n-1, otherwise the pointer may get out of bounds.
If the mid is the first occurrence, we check if it is at an even index. If it is, it means that the mid lies to the left of the single element.
The pointer l gets updated. If the mid is not even, it means it lies on the right of the single element and r pointer gets updated.

[2] this condition checks if mid is the second occurrence, by checking if nums[mid-1] == nums[mid] or not.
We also check if ( mid - 1 ) > 0, to prevent the pointer getting out of bounds.
If the condition is satisfied, then we check if mid is odd or not, as it should be if the element is to the left of the single element.
If it is odd, then l gets updated, other the r pointer gets updated.

If both of these conditions are not met, that means nums[mid] is the required single element and it is returned to the main function.
*/
