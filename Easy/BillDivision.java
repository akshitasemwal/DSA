/*
Two friends Anna and Brian, are deciding how to split the bill at a dinner. Each will only pay for the items they consume.
Brian gets the check and calculates Anna's portion. You must determine if his calculation is correct.
https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true
*/

package Easy;
import java.util.*;

public class BillDivision {
    public static void main(String[] args) {
        int items = 4;
        int skipped = 1;
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        int charged = 12;
        bonAppetit(bill, skipped, charged);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int n = bill.size();
        int actual = 0;
        for(int i =0; i<n; i++)
        {
            if( i != k)
            {
                actual += bill.get(i);
            }
        }
        actual /= 2;
        if( b != actual)
            System.out.println( b-actual );
        else
            System.out.println("Bon Appetit");
    }
}
