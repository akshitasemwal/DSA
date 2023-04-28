/*
Given an array with repeated elements, the task is to find the maximum distance between two occurrences of an element.
TC: O(n)
SC: O(n)
https://www.geeksforgeeks.org/maximum-distance-two-occurrences-element-array/
*/

import java.util.*;
public class MaxDistance {
    public static void main(String[] args) {
        int n = 12;
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        maxDistance(arr, n);
    }

    static void maxDistance(int arr[], int n)
    {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            if(!map.containsKey(arr[i]))                    //[1]
            {
                map.put(arr[i], i);
            }
            else                                            //[2]
            {
                if((i - map.get(arr[i])) > max)
                {
                    max = i - map.get(arr[i]);
                }
            }
        }
        System.out.println(max);
    }
}

/*
[1] in this solution, if the element isn't found in the map,
it is inserted into it along with its index,i.e, the element's first occurrence.
[2] if the map contains the element, its first occurrence index is compared with the current index.
If the difference between the indices is greater than the difference found between the current and the first occurrence of any other elements,
the diff is saved into variable max and printed.
 */
