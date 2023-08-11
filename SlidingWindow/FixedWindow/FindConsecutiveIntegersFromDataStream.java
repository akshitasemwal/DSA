/*
For a stream of integers, implement a data structure that checks if the last k integers parsed in the stream are equal to value.
Implement the DataStream class:
DataStream(int value, int k) Initializes the object with an empty integer stream and the two integers value and k.
boolean consec(int num) Adds num to the stream of integers. Returns true if the last k integers are equal to value, and false otherwise.
If there are less than k integers, the condition does not hold true, so returns false.
https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/description/
TC: O(1)
SC: O(n)
*/

package SlidingWindow.FixedWindow;
import java.util.*;

public class FindConsecutiveIntegersFromDataStream {
    public static void main(String[] args) {
        DataStream obj = new DataStream(4, 3);
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(4));
        System.out.println(obj.consec(3));
    }
}

class DataStream {
    int value;
    int k;
    int i;
    int j;
    List<Integer>list;
    int count;

    public DataStream(int value, int k)     //initialising all the required variables
    {
        this.value=value;
        this.k=k;
        this.i=0;
        this.j=0;
        this.count=0;
        this.list=new ArrayList<>();
    }

    public boolean consec(int num)
    {
        boolean ans = false;
        list.add(num);

        if(list.get(j) == value)              //[1]
        {
            count++;
        }

        if((j-i+1) < k)                       //[2]
        {
            j++;
            return false;
        }
        else if((j-i+1) == k)                 //[3]
        {
            if(count == k)
            {
                ans = true;
            }
            else
            {
                ans = false;
            }
            if(list.get(i) == value)
            {
                count = count - 1;
            }
            i++;
            j++;
        }
        return ans;
    }
}

/*
This solution uses sliding window technique to traverse through given values,
while keeping in check that all the values in a particular window of size k, consist of a fixed value.

[1] if the newly added element at index j in the list is equal to the value,
it means we have found another consecutive occurrence of value within the window.
So, we increment the count variable.
[2] If the size of the current window (i.e., j - i + 1) is less than k, it means the window is not fully filled yet.
In such cases, we increment the j pointer and return false to indicate that the current element is not part of a consecutive sequence.
[3] if window size is equal to k, it means the window is full. Now we need to check for 2 things:
if the count of values which are equal to the given value is equal to k or not,
and we check if the value at the end(left) of the window is equal to the required value or not.
If the element at index i in the list is equal to the value,
it means the element at the left end of the window is the value, and we decrement count by 1.
When the left end of the window moves forward (incrementing i), it means the element at index i is no longer part of the window.
Therefore, we need to update the count variable accordingly.
Finally, we increment both i and j pointers to slide the window by one position.
*/