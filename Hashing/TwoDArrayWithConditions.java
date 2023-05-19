/*
You are given an integer array arr. You need to create a 2D array from arr satisfying the following conditions:
The 2D array should contain only the elements of the array arr.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.
TC: O(n^2)
SC: O(n)
https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
*/

package Hashing;
import java.util.*;

public class TwoDArrayWithConditions {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 2, 3, 1};
        findMatrix(arr);
    }

    public static void findMatrix(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n+1];
        for(int i = 0; i<n; i++)
        {
            freq[arr[i]]++;
        }
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i = 0; i<=n; i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j<n; j++)
            {
                if(freq[arr[j]]>0 && !list.contains(arr[j]))
                {
                    list.add(arr[j]);
                    freq[arr[j]]--;
                }
            }
            if(list.size()>0)
            {
                matrix.add(list);
            }
        }
        for(int i = 0; i<matrix.size(); i++)
        {
            for(int j = 0; j<matrix.get(i).size(); j++)
            {
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}

/*
This solution uses frequency array to store all the frequencies of distinct elements present in the array.
It then creates a 2D arraylist to store all the distinct elements in each row, to get minimum number of rows.
*/
