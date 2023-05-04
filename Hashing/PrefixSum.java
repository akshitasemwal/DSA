/*
You are given a list of N numbers. A query is specified by two numbers i and j.
The answer to each query is the sum of every number between the range [i, j] (inclusive).
TC: O(j-i) -> worst = O(n)
SC: O(1)
https://www.spoj.com/problems/CSUMQ/
 */

package Hashing;
public class PrefixSum {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 4, 1, 6 , 2, 8};
        int num1 = 2;
        int num2 = 5;
        prefixSum1(arr, num1, num2);
        prefixSum2(arr, num1, num2);
    }

    static void prefixSum1(int[] arr, int num1, int num2){
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        int number = prefixSum[num2] - prefixSum[num1-1];
        System.out.println(number);
    }

    static void prefixSum2(int[] arr, int num1, int num2){
         for(int i = num1 + 1; i <= num2; i++){
             arr[i] += arr[i-1];
         }
        System.out.println(arr[num2]);
    }
}

/*
[1] this solution uses conventional method of calculating the prefix sum for the entire array and then printing the required number.
[2] this solution uses the prefix sum technique to store successive sum of the elements in the array.
It stores the sum of all the elements upto that particular element, i.e, from index 0 to i.
*/