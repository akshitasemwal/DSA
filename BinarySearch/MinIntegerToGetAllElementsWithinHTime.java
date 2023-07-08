/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
https://leetcode.com/problems/koko-eating-bananas/description/
TC: O(n log n)
SC: O(1)
*/

package BinarySearch;

public class MinIntegerToGetAllElementsWithinHTime {
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxEle = piles[0];
        for(int i = 0; i<n; i++)
        {
            maxEle = Math.max( piles[i], maxEle );                       //[1]
        }
        int l = 1;
        int r = maxEle;
        int mid = l + ( r - l ) / 2;
        int k = maxEle;
        while ( l <= r )
        {
            long timeTaken = 0;
            mid = l + ( r - l ) / 2;
            for(int i = 0; i<n; i++)                                     //[2]
            {
                timeTaken += ( int )Math.ceil( (piles[i] * 1.0) / mid );
            }
            if ( timeTaken > h )                                         //[3]
            {
                l = mid + 1;
            }
            else
            {
                k = mid;
                r = mid - 1;
            }
        }
        return k;
    }
}

/*
Instead of using the traditional method to solve this question using 2 loops, checking for each value between the search space,
we use binary search method as number of bananas that can be consumed in 1 hour is monotonically increasing.

[1] the search space is from 1 to the max element in the array, as these can be the minimum and maximum values of k(number of bananas eaten per hour) respectively.
[2] we check the time consumed for every mid. Instead of adding on the remaining bananas to the next pile[i],
we calculate the total time for that particular pile. For example, since she wont be able to eat 30 bananas in one hour as k = 23,
instead of calculating: 1 hour for 23 bananas, and adding the remaining 7 to the next pile, we calculate the cumulative time for all the piles.
[3] if time calculated for that k is greater than the given time, it means the number of bananas eaten per hour needs to be increased.
Hence, pointer l is updated.
[4] if time is greater than or equal to h, it means that mid is a possible value for k, and hence it is stored in k.
Since there is still a possibility of finding the upper bound of h which will be lesser than current value of k,
we need to update r pointer. If no other mid is found such that the time calculated for it is greater than or equal to h,
the previously saved value of k is returned.
*/