/*
The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height.
Each summer, its height increases by 1 meter.
A Utopian Tree sapling with a height of 1 meter is planted at the onset of spring.
How tall will the tree be after n growth cycles?
https://www.hackerrank.com/challenges/utopian-tree/problem?isFullScreen=true
SC: O(1)
TC: O(1)
*/

package Easy;

public class UtopianTree {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(utopianTree(n));
    }

    public static int utopianTree(int n) {
        if(n==0) return 1;
        if(n==1) return 2;
        if(n%2!=0)
        {
            return 2*n;
        }
        else
        {
            return (2*(n-1))+1;
        }
    }
}
