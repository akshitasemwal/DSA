/*
Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type.
If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true
TC: O(n)
SC: O(n)
*/

package Easy;
import java.util.*;

public class IDOfMaxFrequency {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 4, 4, 4, 5, 3);
        System.out.println(migratoryBirds(arr));
    }

    public static int migratoryBirds(List<Integer> arr) {
        int n = arr.size();
        int[] freq = new int[n];
        int max = 0;
        int type = 0;
        for(int i = 0; i<n; i++)
        {
            freq[arr.get(i)]++;
        }
        for(int i = 0; i<n; i++)
        {
            if( freq[i] == max && i<type)
            {
                type = i;
                max = freq[i];
            }
            else if( freq[i] > max )
            {
                type = i;
                max = freq[i];
            }
        }
        return type;
    }
}
