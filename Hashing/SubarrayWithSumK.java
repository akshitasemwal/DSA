/*
https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n)
SC: O(n)
*/

package Hashing;
import java.util.*;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 5};
        int k = 33;
        subarraySum(arr, k);
    }

    public static void subarraySum(int[] arr, int k)
    {
        int n = arr.length;
        int prefixSum=0;
        Map<Integer,Integer> hmap=new HashMap<>();
        hmap.put(0,1);
        int count=0;
        for(int i=0;i<n;i++){

            prefixSum = prefixSum + arr[i];
            if(hmap.containsKey(prefixSum-k))
            {
                count=count+hmap.get(prefixSum-k);
                if(hmap.containsKey(prefixSum))
                {
                    int value=hmap.get(prefixSum);
                    hmap.put(prefixSum,value+1);
                }
                else{
                    hmap.put(prefixSum,1);
                }
            }
            else{
                if(hmap.containsKey(prefixSum))
                {
                    int value=hmap.get(prefixSum);
                    hmap.put(prefixSum,value+1);
                }
                else
                {
                    hmap.put(prefixSum,1);
                }
            }
        }
        System.out.println(count);
    }
}
