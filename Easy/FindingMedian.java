/*
Given a list of numbers with an odd number of elements, find the median.
https://www.hackerrank.com/challenges/find-the-median/problem?isFullScreen=true
TC: O(n log n)
SC: O(1)
*/

package Easy;
import java.util.*;

public class FindingMedian {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 4, 5, 9, 8);
        System.out.println(findMedian(arr));
    }

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        if(arr.size()%2==0)
        {
            return (arr.get(arr.size()/2)+arr.get(arr.size()/2-1))/2;
        }
        else
        {
            return (arr.get(arr.size()/2));
        }
    }
}
