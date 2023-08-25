/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/

package Backtracking;
import java.util.*;

public class CombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits)
    {
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backTrack(digits, 0 , map, new StringBuilder(), res);
        return res;
    }

    private static void backTrack(String digits, int i, Map<Character,String> map, StringBuilder sb,List<String>res)
    {
        if(i==digits.length())
        {
            res.add(sb.toString());
            return;
        }

        String curr = map.get(digits.charAt(i));
        for(int k=0; k<curr.length(); k++)
        {
            sb.append(curr.charAt(k));
            backTrack(digits, i+1, map,  sb, res);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
