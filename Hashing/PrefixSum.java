/*
You are given a list of N numbers. A query is specified by two numbers i and j.
The answer to each query is the sum of every number between the range [i, j] (inclusive).
TC: O(j-i) -> worst = O(n)
SC: O(1)
 */

public class PrefixSum {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 4, 1, 6 , 2, 8};
        int num1 = 2;
        int num2 = 5;
        prefixSum(arr, num1, num2);
    }

    static void prefixSum(int[] arr, int num1, int num2){
         for(int i = num1 + 1; i <= num2; i++){
             arr[i] += arr[i-1];
         }
        System.out.print(arr[num2]);
    }
}

/*
This solution uses the prefix sum technique to store successive sum of the elements in the array.
It stores the sum of all the elements upto that particular element.
 */