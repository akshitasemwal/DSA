/*
You are given a binary string S. A binary string is a string consisting of only 0's and 1's.
A binary string is called good if it has an equal number of occurrences of 01 substrings and 10 substrings.
Note that these substrings may overlap. For example, the string 1101001 is good since there are two occurrences of 01 and 10 respectively.
Find the number of indices (1≤i≤∣S∣) such that after flipping, the resultant binary string is good.
https://www.codechef.com/problems/GOODBINSTR
*/

package Hashing;
public class GoodBinaryStrings {
    public static void main (String[] args)
    {
        String str = "0100101";
        int res = solve(str);
        System.out.println(res);
    }
    static int solve(String s){
        int n = s.length();
        if(s.charAt(0) != s.charAt(n-1))
            return 2;
        else
            return n-2;
    }
}

/*
S = [0, 1, 0, 0, 1, 0, 1]
     0  1  2  3  4  5  6
x -> 01 -> 3,
y -> 10 -> 2

On flipping indices:
0: x = 2, y = 2
1: x = 2, y = 1
2: x = 3, y = 2
3: x = 3, y = 2
4: x = 2, y = 1
5: x = 2, y = 1
6: x = 2, y = 2
Ergo, output = 2

We come to a conclusion that there are 3 cases for S[i] such that (0 < i < n-1), i.e, i lies between the 0th and the last element.
For these conditions, the difference between x and y values remains same, nevertheless.
After flipping S[i],
if S[i-1] != S[i+1], no change in og x and y values.
if S[i-1] = S[i+1], two cases arise:
a. S[i] != S[i-1], og x and y values(occurrences) get incremented by 1. (difference still remains same)
b. S[i] = S[i-1], og x and y values(occurrences) get decremented by 1. (difference still remains same)

Condition a happens because:
     0  1  2  3  4  5  6
S = [0, 1, 0, 0, 0, 0, 1]
x = 2, y = 1
let i = 4
S[3] = S[5]
and after flipping, S[3] != S[4]
[0, 1, 0, 0, 1, 0, 1]
x -> 0,1 and 5,6 -> 0,1 , 3,4 and 5,6
y -> 1,2 -> 1,2 and 4,5
x = 2, y = 1 -> x = 3, y = 2

Condition b happens because:
     0  1  2  3  4  5  6
S = [0, 1, 0, 0, 1, 0, 1]
let i = 5
S[4] = S[6]
and after flipping, S[4] = S[5]
[0, 1, 0, 0, 1, 1, 1]
x -> 0,1 , 3,4 and 5,6 -> 0,1 and 3,4 remaining
y -> 1,2 and 4,5 -> 1,2 remaining
x = 3, y = 2 -> x = 2, y = 1

Initial values of x and y are calculated.
By the above observation, the required number of flips will be n-2 if the initial difference between x and y is 0, otherwise thr required flips remain 0 too as the difference always remains constant.
If first and last elements are same, then x and y will remain same.
Because the n-2 middle elements make no change in the difference between x and y, the no. of flips will be n-2(difference is 0).
01'0' -> '10, 011
If they are different, then difference between x and y will be 1, and then we will return 2 as the no. of flips.
In this case we will flip the end points one by one, then one time we will decrement x(or increment x) and make it equal to y, and the other time we will decrement y(or increment y) to make it equal to x
*/