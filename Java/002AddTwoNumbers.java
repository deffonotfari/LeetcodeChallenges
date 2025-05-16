/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //We need to create a temporary head to build both lists
    	ListNode head = new ListNode(0);
    	ListNode curr = head;
    	int carry = 0;

        //Traversing both lists
    	while (l1 != null || l2!= null) {
             // Get current values or 0 if list is finished
    		int x = (l1 != null) ? l1.val : 0;
    		int y = (l2 != null) ? l2.val : 0;

            //Calculate sum and carry
    		int digit = carry + x + y;
    		carry = digit / 10;

            //Create new node with the digit
    		curr.next = new ListNode(digit % 10);
    		curr = curr.next;

            //Move to next nodes
    		if (l1 != null) l1 = l1.next;
    		if (l2 != null) l2 = l2.next;
    	}

        //Add final carry if it exists
    	if (carry > 0) {
    		curr.next = new ListNode(carry);
    	}

        //Return the result list (skip dummy head)
    	return head.next;
    }
}
