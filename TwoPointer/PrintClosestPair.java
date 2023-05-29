/*
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
TC: O(n log n)
SC: O(1)
*/

package TwoPointer;
import java.util.*;

public class PrintClosestPair {
    public static void main(String[] args) {
        int a[]={1, 4, 7, 5};
        int b[]={10, 30, 20, 40};
        int x=32;
        System.out.println(printClosest1(a, b, x));
    }
    static ArrayList<Integer> printClosest1 (int arr[], int brr[], int x) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(arr);
        Arrays.sort(brr);

        int n = arr.length;
        int m = brr.length;

        int diff = 0;                      //stores the absolute difference between x and the sum of the numbers
        int min = Integer.MAX_VALUE;       //stores the min diff between x and the sum of the numbers

        int p = 0;                         //store the required numbers temporarily
        int q = 0;

        int i = 0;
        int j = m-1;
        while( i < n && j >= 0 )           //while the pointers are still pointing to the elements in the array
        {
            diff = Math.abs( x - (arr[i] + brr[j]) );       //calculate the absolute diff between x and the sum of the numbers
            if(min - Math.min(min, diff) != 0)              //if the difference between diff and min !=0, i.e., the new value of diff is different
            {
                min = Math.min(min, diff);                  //min will store the minimum value of new diff or the last min
                p = arr[i];
                q = brr[j];
            }
            if(( arr[i] + brr[j] ) > x)                      //if the sum of the numbers is greater than x, j is decremented
            {
                j--;
            }
            else if(( arr[i] + brr[j] ) < x)                 //if the sum of the numbers is greater than x, i is incremented
            {
                i++;
            }
            else if( diff == 0 )
            {
                break;
            }
        }
        ans.add(p);
        ans.add(q);
        return ans;
    }
}

/*
The solution aims at finding the pair of numbers such that 1 number is taken from each array, and the sum of the numbers is closest to the given x.

We use the 2 pointer approach to find the solution of this problem.
 */