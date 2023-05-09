/*
Given an array of integers A and an integer B.
Find the total number of subarrays having bitwise XOR of all elements equals to B.
https://www.interviewbit.com/problems/subarray-with-given-xor/
TC: O(n)
SC: O(n)
*/

package Hashing;
import java.util.*;

public class SubarraysHavingXOR {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subarraysXOR(arr, k));
    }
    public static int subarraysXOR(int[] arr, int k) {
        int n = arr.length;
        int xor = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i<n; i++)
        {
            xor ^= arr[i];
            if(map.containsKey(xor^k))
            {
                count += map.get(xor^k);
            }
            if(map.containsKey(xor))
            {
                map.put(xor, map.get(xor)+1);
            }
            else
            {
                map.put(xor, 1);
            }
        }
        return count;
    }
}

/*
This solution works on the same principles as tha last two solutions.
It finds the unknown, with the help of xor up till the current element, and given k.
It uses property of xor:
a^b = c
b^c = a
a^c = b

i.e., xor ^ k = the unknown x.
If this unknown x exists in the map, the number of subarrays with given k will be equal to the frequency of the xor^k.
*/