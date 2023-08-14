/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
https://leetcode.com/problems/fruit-into-baskets/description/
TC: O(n)
SC: O(n)
*/

package SlidingWindow.VariableWindow;
import java.util.*;

public class LongestSubarrayWithKRepeatingCharacters {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while ( j < n )
        {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size() <= 2)    //if the size of the map is less than or equal to 2, it means that it contains atleast 1 type of fruits
            {
                max = Math.max((j - i + 1), max);
            }
            if(map.size() > 2)
            {
                while(map.size()>2)
                {
                    map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                    if(map.get(fruits[i]) <= 0)
                    {
                        map.remove(fruits[i]);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}

/*
Problem similar to longest substring with k repeating characters.
*/