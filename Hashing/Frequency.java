/*
Find frequency of each number in the given array.
SC: O(n)
TC: O(n)
https://www.geeksforgeeks.org/find-frequency-number-array/
*/

import java.util.*;

public class Frequency {
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {2, 3, 3, 5, 2, 5, 5, 5, 5};
        freq(arr, n);
    }

    static void freq(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(arr[i]))                       //[1]
            {
                map.put( map.get(arr[i]), map.get(arr[i])+1 );
            }
            else                                              //[2]
            {
                map.put( arr[i], 1);
            }
        }
        for (Map.Entry num:map.entrySet())
        {
            System.out.println( num.getKey() + "->" + num.getValue());
        }
    }
}

/*
This solution uses a hashmap to store the frequency of the elements present in the array.
[1] this condition checks if the map contains the current element of the array.
If the element is present,  map.get(arr[i]) finds the frequency of arr[i] and increments it by 1.

[2] if the element isn't present in the map, it is put into the map with its value as 1.
 */