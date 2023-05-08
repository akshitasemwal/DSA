/*
Arrival times go from on time (arrivalTime<=0) to arrived late (arrivalTime>0).
Given the arrival time of each student and a threshhold number of attendees, determine if the class is cancelled.
https://www.hackerrank.com/challenges/angry-professor/problem?isFullScreen=true
TC: O(n)
SC: O(1)
*/

package Easy;

import java.util.Arrays;
import java.util.List;

public class AngryProfessor {
    public static void main(String[] args) {
        int k = 3;
        List<Integer> arr = Arrays.asList(-1, -3, 4, 2);
        System.out.println(angryProfessor(k, arr));
    }

    public static String angryProfessor(int k, List<Integer> a) {
        int num = 0;
        for(int i = 0; i<a.size(); i++)
        {
            if(a.get(i)<=0)
            {
                num++;
            }
        }
        if(num>=k)
            return ("NO");
        else
            return ("YES");
    }
}
