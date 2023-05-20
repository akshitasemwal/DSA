/*
Given an array with the number of steps a grasshopper can take.
Find the index of lowest stair such that while traversing the steps in the array, it still remains on the possible stair,
i.e., after each jump/move, the step grasshopper is on is >=1.
*/

package Hashing;

public class LowestStartingStair {
    public static void main(String[] args) {
        int[] jumps = {1, -4, -2, 3, -7 , 11};
        lowestStair(jumps);
    }

    static void lowestStair(int[] arr)
    {
        int n = arr.length;

        int min = arr[0];
        for(int i = 1; i<n; i++)
        {
            arr[i] += arr[i-1];
            if(min > arr[i])
            {
                min = arr[i];
            }
        }
        if( min > 0 )                     //[1]
        {
            System.out.println(1);
            return;
        }
        int result = 1 + Math.abs(min);   //[2]
        System.out.println(result);
    }
}

/*
We are approaching the solution to this problem greedily.
This solution uses prefix sum to calculate the index of the lowest stair the grasshopper can start from to remain on the stairs during his entire journey.
We then calculate the minimum index of the prefix sum array, and store the min index of the stair.
[1] if min index is >=1 then, all the jumps will be on the stair itself. Hence min index will also be 1.
[2] if min index is negative, then we add 1 to its absolute value as 1 is the minimum index of the stairs.
-5 -4 -3 -2 -1 0 1 : we need to take 6 more steps to get to 1.
*/
