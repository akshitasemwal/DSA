/*
Given an array A consisting of N integers, returns the maximum sum of two numbers whose digits add up to an equal sum.
if there are not two numbers whose digits have an equal sum, the function should return -1.
Constraints: N is integer within the range [1, 200000]
each element of array A is an integer within the range [1, 1000000000]
SC: O(1): max number = 10^10 = 1, 9^9 = 9+9+9+9+9+9+9+9+9 = 81 ; O(81)
TC: O(n)
*/

package Hashing;
import java.util.*;

public class EqualSumDigits {
    public static void main(String[] args) {
        int[] arr = {51, 71, 17, 42};
        int n = 4;
        maxSum(arr, n);
    }

    static void maxSum(int[] arr, int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        int currSum = -1;
        for(int i = 0; i<n; i++)
        {
            int num = arr[i];
            int dSum = 0;
            while( num > 0 )                      //calculating sum of digits
            {
                dSum += (num%10);
                num /= 10;
            }
            if(map.containsKey( dSum ))           //[1]
            {
                currSum = arr[i] + map.get(dSum);
                max = Math.max( currSum, max);
                map.put(dSum, (Math.max( arr[i], map.get(dSum) ) ));   //[2]
            }
            else                                  //[3]
            {
                map.put( dSum, arr[i]);
            }
        }
        System.out.println(max);
    }
}

/*
This solution uses a hashmap to store the digit sum along with its number.

[1] If a particular sum of digits already exists in the hashmap,
then we will add the numbers and store it in currSum. If it is greater than max then max = currSum.
[2] if the current number is greater than the previous number whose digits sum is same,
then the greater of the previous number(map.get(dSum)) or the current number(arr[i]) will be the value of dSum to maximize the max sum.
[3] if the digit sum is not in the hashmap, it is inputted along with its number.
 */