/*
Given an array of integers nums and an integer target.
Return indices of the two numbers such that they add up to target.
TC: O(2n) -> O(n)
SC: O(n)
https://leetcode.com/problems/two-sum/
 */

package Hashing;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int target = 9;
        int[] arr = {2, 7, -1, 15, 3, 6, 10};
        twoSum(arr, target);
        System.out.println(hasArrayTwoCandidates(arr, target));
    }

    static void twoSum(int[] arr, int target){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)                       //[1]
        {
            map.put(arr[i], i);
        }
        for(int i = 0; i < n; i++)                       //[2]
        {
            int requiredNumber = target - arr[i];
            if(map.containsKey(requiredNumber) && i < map.get(requiredNumber) )
            {
                System.out.println( i +" "+ map.get(requiredNumber) );
            }
        }
    }

    static boolean hasArrayTwoCandidates(int arr[], int target) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            map.put(arr[i], i);
        }
        for(int i = 0; i<n; i++)
        {
            int requiredNumber = target - arr[i];
            if(map.containsKey(requiredNumber) && map.get(requiredNumber)!=i )
            {
                return true;
            }
            //System.out.println(requiredNumber);
        }
        return false;
    }
}

/*
This solution uses a hashmap to find the values such that their sum is equal to the given target.
[1] this loop inserts the elements in the array with their respective indices.

[2] this loop uses arr[i] + requiredNumber = target to find if the requiredNumber = target - arr[i] is present in the hashmap or not.
If it is present, then index of requiredNumber, printed along with the index of the current element.
i < map.get(requiredNumber) is used to check if the current element comes before the element to be searched,
so that repetition/inverse is not printed.
 */
