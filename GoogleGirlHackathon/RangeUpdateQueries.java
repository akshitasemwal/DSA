/*
You are given an array of all empty zeroes. You are given Q queries.
For each query, you need to add “1” from [L,R] array. Print the final array after all queries are performed.
TC: O(n+m)
SC: O(n)
*/

package GoogleGirlHackathon;

public class RangeUpdateQueries {
    public static void main(String[] args) {
        int n = 11;
        int[] l = {5, 10};
        int[] r = {7, 11};
        updateBrute(n, l, r);
        updateOptimized(n, l, r);
    }

    static void updateBrute(int n, int[] l, int[] r)    //O(n*m)
    {
        int[] arr = new int[n];
        int m = l.length;
        for(int i = 0; i<m; i++)
        {
            for(int j = l[i]; j<=r[i]; j++)
            {
                arr[j-1] += 1;
            }
        }
        for(int i = 0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void updateOptimized(int n, int[] l, int[] r) //O(n+q)
    {
        int m = l.length;
        int[] arr = new int[n];
        for(int i = 0; i<m; i++)                 //[1]
        {
            if(l[i]<n)
            {
                arr[l[i]-1] += 1;
            }
            if(r[i] < n)
            {
                arr[r[i]] += -1;
            }
        }
        for(int i = 1; i<n; i++)                 //[2]
        {
            arr[i] += arr[i-1];
        }
        for(int i = 0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
This solution uses update range or difference array trick.

[1] it updates the array by adding 1 at L index, and subtracting 1 from R+1 index in the array.
We do this for all the queries, hence the time complexity is O(n+m), n being the prescribed size of the array and m being the number of queries.
[2] then, we calculate the prefix sum of the array and the later print it.
*/