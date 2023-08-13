/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.
https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
TC: O(n)
SC: O(1)
*/

package LeetcodeContests.WeeklyContest358;
import LinkedLists.ListNode;

public class DoubleNumbersInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode temp = head;
        temp.next = new ListNode(9);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = doubleIt(head);
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

    public static ListNode doubleIt(ListNode head) {
        ListNode c = new ListNode(0, head);                  //[1]
        ListNode curr = c;                                       //temporary pointer to current node
        while ( curr!= null )
        {
            ListNode n = curr.next;                              //temporary pointer to next node
            if( n == null )                                      //[2]
            {
                curr.val = (curr.val * 2) % 10;
            }
            else
            {
                curr.val = (curr.val*2 + (n.val >= 5 ? 1 : 0 )) %10;
            }
            curr = curr.next;
        }
        if( c.val == 0 )                                        //[3]
        {
            c = c.next;
        }
        return c;
    }
}

/*
[1, 3] a new node is created at the beginning of the list, to store the initial carry if required.
If the value of c remains 0 after the entire operation, it means there was no carry over to the new node,
and c can be moved to the next node.

[2] if the n is null, it means curr is at the last node.
In this case, there will be no carry over from the next node to the curr node.
The digit at the units place can directly replace the value in the last node.

[3] if the n is not null, it means there are possibilities of carry over from the next node.
To check if there is a carry or not, we use the ternary operation: n.val >= 5 ? 1 : 0,
i.e., if the next element is greater than or equal to 5,
it definitely means than its double will generate a carry 1, which needs to be added to the value in the curr node.
Since this node has already acted as the next node for the previous node,
only the digit at the units place is made the new value of the current node.
*/