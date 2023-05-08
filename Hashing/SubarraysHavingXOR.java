/*
Given an array of integers arr[] and a number m, count the number of subarrays having XOR of their elements as m.
*/

package Hashing;
import java.util.*;

public class SubarraysHavingXOR {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 2, 2, 6, 4);
        int B = 6;
        int n = 4;
        subarraysXOR(A, B, n);
    }
    public static void subarraysXOR(List<Integer> A, int B, int n){
        Map<Integer,Integer> hmap=new HashMap<>();
        int prefixXor = 0;
        int count = 0;
        hmap.put(0,1);
        for(int i=0; i<A.size(); i++)
        {
            prefixXor = prefixXor^A.get(i);
            if(hmap.containsKey( prefixXor^B ))
            {
                count = count+hmap.get(prefixXor^B);
                if(hmap.containsKey(prefixXor))
                {
                    int value = hmap.get(prefixXor);
                    hmap.put(prefixXor,value+1);
                }
                else{
                    hmap.put(prefixXor,1);
                }
            }
            else{
                if(hmap.containsKey(prefixXor))
                {
                    int value = hmap.get(prefixXor);
                    hmap.put(prefixXor,value+1);
                }
                else{
                    hmap.put(prefixXor,1);
                }
            }
        }
        System.out.println(count);
    }
    }

}
