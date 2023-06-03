/*
You are standing at the top of the skyscrapper in NYC with camera, find the direction you should face to take the photo with most buildings.
arr = [5, 9, 20, 22, 28, 35, 60, 350, 358, 359, 360]
field of view = 30
https://leetcode.com/discuss/interview-question/3549864/Google-or-sliding-window
*/

package TwoPointer;

public class MaxSubarrayGoogleOA {
    public static void main(String[] args) {
        int[] arr = {5, 9, 20, 22, 28, 35, 60, 350,353, 355, 357, 358, 359, 360};
        int k = 30;
        maxView( arr, k);
    }

    static void maxView(int[] arr, int k)
    {
        int n = arr.length;
        int i = 0;                                  //to traverse the array
        int j = 0;

        int p = 0;                                  //to store the index of the longest subarray
        int q = 0;

        int ans = Integer.MIN_VALUE;                //to store the length of the max subarray
        int diff = 0;                               //store the absolute diff between i and j index
        while (i<n && j<n)
        {
            diff = Math.abs(arr[j] - arr[i]);       //[1]
            if(diff<=k)
            {
                int l = j-i+1;
                if(l>ans)
                {
                    ans = l;
                    p = i;
                    q = j;
                }
            }
            else                                   //[2]
            {
                i = j;
            }
            j++;
        }
        System.out.println(ans+" "+p+" "+q);
        int mid;
        if(ans%2==0)
        {
            mid = (arr[i+ans/2] + arr[i+ans/2-1])/2;
        }
        else
        {
            mid = arr[i+ ans/2];
        }
        System.out.println(mid);
    }
}

/*
First and last element of the subarray should have a difference less than 30 degree.
Using the above statement, we use 2 pointers to traverse the array while the pointers are still pointing to the elements in the array.

[1] we calculate the difference between the pointers.
If the difference is <= to k, it means that the elements lying between i and j are in the given range of degrees.
Now we just have to compare the max length till now, and the length between current pointers.
If the new length is longer, then we can update ans(old max length) and save the starting and ending index of the subarray.

[2] if the diff >k, then instead of calculating the difference between the entire subarray again by incrementing the i pointer, we directly start to check a new subarray for the required conditions.
We do so because even if we increment the i, length of the longest subarray remains the same,i,e, length of the subarray will on ly decrease if we increment i while j remains constant.
*/