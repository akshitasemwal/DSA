/*
Count how many candles are tallest.
https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true

*/

package Easy;
import java.util.*;

public class CountCandles {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 4, 1, 3, 2);
        System.out.println(birthdayCakeCandles(arr));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<candles.size(); i++)
        {
            if(candles.get(i)>max)
            {
                max = candles.get(i);
            }
        }
        for(int i = 0; i<candles.size(); i++)
        {
            if(candles.get(i) == max)
            {
                sum++;
            }
        }
        return sum;
    }
}
