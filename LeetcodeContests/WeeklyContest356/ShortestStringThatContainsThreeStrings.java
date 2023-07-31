/*
Given three strings a, b, and c, your task is to find a string that has the minimum length and contains all three strings as substrings.
If there are multiple such strings, return the lexicographically smallest one.
Return a string denoting the answer to the problem.
https://leetcode.com/problems/shortest-string-that-contains-three-strings/
*/

package LeetcodeContests.WeeklyContest356;

public class ShortestStringThatContainsThreeStrings {
    public static void main(String[] args) {
        String a = "abc";
        String b = "bca";
        String c = "aaa";
        System.out.println(minimumString(a, b, c));
    }

    public static String min(String a, String b)                 //[1]
    {
        if( a.length() > b.length() )
        {
            return b;
        }
        if( a.length() < b.length() )
        {
            return a;
        }
        return a.compareTo(b) <= 0 ? a : b;
    }

    public static String union(String a, String b)               //[2]
    {
        if( a.contains(b) )                                      //[3]
        {
            return a;
        }
        if( b.contains(a) )
        {
            return b;
        }

        int n = a.length();
        int m = b.length();
        int i = n - 1;
        int j = 0;
        int k = 0;
        while( i>= 0 && j<m )                                   //[4]
        {
            if( a.substring(i).equals(b.substring(0, j+1)) )
            {
                k = j + 1;
            }
            i--;
            j++;
        }
        return a+b.substring(k);
    }


    public static String minimumString(String a, String b, String c) {
        String abc = union(union(a, b), c);
        String acb = union(union(a, c), b);
        String bac = union(union(b, a), c);
        String bca = union(union(b, c), a);
        String cab = union(union(c, a), b);
        String cba = union(union(c, b), a);

        String res = min(abc, acb);
        res = min(res, bac);
        res = min(res, bca);
        res = min(res, cab);
        res = min(res, cba);

        return res;
    }
}

/*
[1] this function returns the minimum string. It first compares both the strings by length, and returns the shorter string.
If the size of both the strings is equal, it uses compareTo function to return the lexicographically shorter string.

[2] this function is responsible to return the union of two strings.
It makes sure that the common substring is not repeated, and only one instance of it occurs throughout the union string.

[3] we check if the entire string is a substring os another string, then the bigger string is returned as it is.

[4] this loop uses two pointers to check if common substrings exist. If it does, we ignore that part from the 2nd string.
We start from the end of 1st string and the beginning of the 2nd string.
If the substring from the end of the first string to the current ith index, i.e., 'a.substring(i)',
equals the substring from the beginning of the 2nd string to the current jth index, i.e., 'b.substring(0, j+1)',
it means that the substring is common, and the kth pointer gets updated to the j + 1th index, to neglect the repeated substring in the 2nd string.

We then return the 1st string as it is, and only the non repeated part of the 2nd string, i.e., b.substring(k).

[5] we know that there can be 6 ways of joining 3 strings, and hence we try to find the union of each method.
After getting all the 6 unions, we know have to find the minimum of these unions, and use the min function for the same.
*/