/*
You are given an array of size “N”. In 1 operation you can change any A[i] to A[i] + x.
You can do these operations only 1 time on each index. Also x should lie in [-K, K].
After doing all these operations, pick up the largest possible set of equal numbers.
https://www.desiqna.in/13650/google-girl-hackathon-coding-questions-solutions-2023-kumar
1<=N<=100000
1<=K<=100000
100000>=A[i]>=K+1
TC: O(n+K)
SC: O(n+m) where m is the difference between max element formed after largest element + k & min element formed after smallest element - k
*/

package GoogleGirlHackathon;

public class MaximizeEqualNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int k = 2;
        maximizeEqualNumbers(arr, k);
    }

    static void maximizeEqualNumbers(int[] arr, int k)
    {
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++)                       //[1]
        {
            l[i] = arr[i] - k;
            r[i] = arr[i] + k;
            min = Math.min(min, l[i]);
            max = Math.max(max, r[i]);
        }

        int m = max - min;
        if(min < 0)
        {
            min = Math.abs(min);
        }
        int[] nums = new int[m + 1];

        for(int i = 0; i<n; i++)                       //[2]
        {
            if(min + l[i] < m)
            {
                nums[min + l[i]] += 1;
            }
            if(min + r[i]+1 < m)
            {
                nums[min + r[i]+1] += -1;
            }
        }

        for(int i = 1; i<m; i++)                       //[3]
        {
            nums[i] += nums[i-1];
        }

        max = Integer.MIN_VALUE;
        for(int i = 0; i<m; i++)                       //[4]
        {
            max = Math.max(max, nums[i]);
        }
        System.out.println(max);
    }
}

/*
Use update range trick.
Then select the max element from the presum array.

[1] we first calculate the minimum(l) and maximum(r) values for each element of the given array,
after adding -k and +k to it, respectively, we store the minimum values in l array and maximum values in r array.
We then calculate the min l value and r value from the l and r arrays to make a new array with size: max - min.
We do this to ensure that the new array can be updated for every possible element that can be made by changing the original elements.

[2] next, we traverse the l and r arrays and use *update change trick* to update the new array of size m(max - min).
We update the new nums array such that we add 1 to every element at l[i] index, and subtract from from every r[i]+1 index.

[3] we now calculate the pre sum to see how many times the max and min range of each element overlaps with each other.
This is done by adding 1 and, and to end the range, we use -1.

[4] from this calculated presum, we now select the max element as this is the maximum times the ranges of the elements could overlap,
and hence the elements could be same.
*/