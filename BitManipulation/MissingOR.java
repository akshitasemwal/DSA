/*
Given an array consisting of n numbers. Find the non-negative number such that when we OR that number with the element in the array, the resulatant equals to y.
3 | 5 | 6 | 2 | x = y
If no such element is present, print -1.
SC: O(1)
TC: O(n)
*/

package BitManipulation;

public class MissingOR {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int y = 8;
        findNumber(arr, y);
    }

    static void findNumber(int[] arr, int y)
    {
        int n = arr.length;
        int val = 1;
        for(int i = 0; i<n; i++)        //[1]
        {
            val = val | arr[i];
        }
        int x = val ^ y;                //[2]
        if( (val | x) == y)             //[3]
        {
            System.out.println(x);
        }
        else
        {
            System.out.println(-1);
        }
    }
}

/*
This solution uses the property of XOR: x^x = 0
[1] 3 | 5 | 6 | 2 = val

val | x = y
val | x ^ x = y ^ x,
x^x=0 -> val = y ^ x
val ^ y = Y ^ x ^ y

[2] y^y=0 -> val ^ y = x

[3] if the value of x suffices the given requirements, then x is printed else -1 is printed.
*/