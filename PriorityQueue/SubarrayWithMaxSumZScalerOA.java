/*
Given an array of size n. FInd the subarray with maximum sum such that the size of the subarray is less than or equal to k.
SC: O(n)
TC: O(nlogn)
*/

package PriorityQueue;
import java.util.*;

public class SubarrayWithMaxSumZScalerOA {
    public static void main(String[] args) {
        int[] arr = {-3, 4, 3, -2, 2, 5};
        int n = 6;
        int k = 4;
        maxSum(arr, n, k);
    }

    static void maxSum(int[] arr, int n, int k)
    {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Map.Entry::getKey)); //[1]
        for(int i = 1; i<n; i++)                                  //[2]
        {
            arr[i] += arr[i-1];
        }
        pq.add(Map.entry(0,0));                             //[7]

        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++)                                  //[3]
        {
            int l = i-k;
            int r = i-1;
            int flag = 0;
            int minKey = Integer.MAX_VALUE;
            while(!pq.isEmpty() && flag == 0)                      //[4]
            {
                Map.Entry<Integer, Integer> map = pq.peek();       //[5]
                int key = map.getKey();
                int value = map.getValue();
                if(value>=l && value<=r)
                {
                    minKey = Math.min(minKey, key);
                    flag=1;
                }
                else
                {
                    pq.poll();
                }
            }
            max = arr[i-1] - minKey;                              //[6]

            pq.add(Map.entry(arr[i-1],i));
        }
        System.out.println(max);
    }
}

/*
This solution uses prefix sum method and min priority queue.

[1] The elements in the priority queue are sorted based on the keys of the entries in ascending order,
using a Comparator that compares the keys of the entries.
The Comparator.comparing method is used to specify the key for comparison.
In this case, Map.Entry::getKey is used as a method reference to extract the key from each Map.Entry object for comparison
and return the elements in ascending order of the extracted keys.

[2]Calculate the prefix sum of the entire array.
Next, to calculate the max subarray sum such that the length is less than or equal to k, we would have to use nested loops,
with the outer loop starting at int i = k.

We would then have to use another loop to check sums of subarrays:
i->i(arr[i] - arr[i-1]) , i->i-1(arr[i]-arr[i-2]), i->i-2(arr[i]-arr[i-3])...i->i-k(arr[i]-arr[i-k-1])
Then we can compare the differences to store the max sum for every index.
Here, i remains constant.
This will take O(n * k) time complexity.
To calculate a sum such that when a number(y) is subtracted from a constant, the sum is maximum;
we need to make sure that the number(y) is minimum.
The other way of doing the same operation was by selecting the minimum element among: arr[i-1], arr[i-2], arr[i-3]..arr[i-k-1].
To reduce the complexity and use above operation efficiently, we will use a min heap.

[3]Now, make a min heap/min priority queue to store the pair of prefix sum with its respective index on the go.
Add (prefix[i], i) into the queue.
[4] To make sure that index of the prefix is > (i-k), we will need to pop the elements from the pq till the valid index is reached.
[5] Because its a min priority queue, the element at the top will be the min prefix sum pushed into the queue till the current index.
[6] Using the above mentioned concept, we will subtract the minimum prefix calculated till now from arr[i]: arr[i] - pq.peek().

[7] By adding (0, 0) as the initial entry, it ensures that the calculation of the maximum sum subarray starts from the beginning of the array (i = 1)
and considers the case where the subarray starts from index 0 with a sum of 0.
*/
