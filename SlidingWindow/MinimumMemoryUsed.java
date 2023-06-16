/*
Given list of processes where each value representing memory consuption by the process,
and given one variable m representing number of processes to be removed.
We need to delete m number of processes from the list in contiguous manner,
and return minimum amount of main memory used by all the proccesses running after deleting contiguous segment of processes.
https://www.desiqna.in/10522/amazon-sde-internship-coding-questions-and-solutions-2022
TC: O(n)
SC: O(1)
*/

package SlidingWindow;

public class MinimumMemoryUsed {
    public static void main(String[] args) {
        int[] processes = {10, 4, 8, 13, 20};
        int m = 2;
        int n = 5;
        removeMProcesses(processes, m, n);
    }

    public static void removeMProcesses(int[] arr, int k, int n)
    {
        int j = 0;
        int totalSum = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++)                      //[1]
        {
            totalSum += arr[i];
        }
        for(int i = 0; i<k; i++)                      //[2]
        {
            sum += arr[i];
        }
        for(int i = k; i<n; i++)                      //[3]
        {
            sum += arr[i] - arr[j];
            j++;
            min = Math.min(min, totalSum-sum);
        }
        System.out.println(min);
    }
}

/*
This solution uses similar approach like solution 1, i.e., using two pointers to set the start and end of a fixed window of size k.
[1] find the total memory usage
[2] find initial memory usage for size k
[3] travers the entire array, and calculate sum for values with the given sliding window.
If the difference between the total sum and the current window is min, it means that this particular window is consuming most memory,
and when we remove these many memory usage tasks, the memory consumption becomes minimum.
We could also simply look for max window, and return the difference between total sum and window(sum).
*/