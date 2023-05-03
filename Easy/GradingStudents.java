/*
https://www.hackerrank.com/challenges/grading/problem?isFullScreen=true
TC: O(n)
SC: O(1)
*/

package Easy;

import java.util.*;

public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 73, 67, 38, 33);
        System.out.println(gradingStudents(arr));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<grades.size(); i++)
        {
            if(grades.get(i)>37 && (grades.get(i)+2)%5 == 0 )
            {
                res.add(grades.get(i)+2);
            }
            else if(grades.get(i)>37 && (grades.get(i)+1)%5 == 0)
            {
                res.add(grades.get(i)+1);
            }
            else
            {
                res.add(grades.get(i));
            }
        }
        return res;
    }
}
