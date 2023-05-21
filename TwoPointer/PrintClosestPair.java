/*
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
TC: O(N)
SC: O(1)
*/

package TwoPointer;
import java.util.*;

public class PrintClosestPair {
    public static void main(String[] args) {
        int a[]={1,4,5,7};
        int b[]={10,20,30,40};
        int x=32;
        System.out.println(printClosest1(a, b, x));
    }
    static ArrayList<Integer> printClosest1 (int arr[], int brr[], int x) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int p=0;
        int q=0;
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=brr.length-1;
        while(i<arr.length && j>=0)
        {
            if(min-Math.min(min,Math.abs(arr[i]+brr[j]-x)) !=0)
            {
                min=Math.min(min,Math.abs(arr[i]+brr[j]-x));
                p=arr[i];
                q=brr[j];
            }
            if((arr[i]+brr[j])>x)
            {
                j--;
            }
            else if((arr[i]+brr[j])<x)
            {
                i++;
            }
            else if((arr[i]+brr[j])==x)
            {
                break;
            }

        }
        ans.add(p);
        ans.add(q);
        return ans;
    }
}
