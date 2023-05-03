/*
A staircase's base and height are both equal to n. It is drawn using # symbols and spaces. The last line is not preceded by any spaces.
Write a program that prints a staircase of size n.
https://www.hackerrank.com/challenges/staircase/problem?isFullScreen=true
TC: O(n^2)
SC: O(1)
 */

package Easy;

public class StaircasePattern {
    public static void main(String[] args) {
        int n = 5;
        staircase(n);
    }
    public static void staircase(int n) {
        for(int i = 0; i<n; i++)
        {
            for(int j = n - i - 1; j > 0; j--)       //loop for spaces " "
            {
                System.out.print(" ");
            }
            for(int j = 1; j<=i+1; j++)
            {
                System.out.print("#");
            }
            System.out.println("");
        }
    }
}
