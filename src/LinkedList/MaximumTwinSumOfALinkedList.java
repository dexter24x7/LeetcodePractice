package LinkedList;
//2130. Maximum Twin Sum of a Linked List
/*
n a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node,
if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for
n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
public class MaximumTwinSumOfALinkedList {
    /** 1.Find the mid of the LL
     2.Reverse the second half of the LL
     3.Find the sum of pairs from fwd and the rev Lists
     4.Return the max of the sum pairs
     */
    public int pairSum(ListNode head) {
        //res stores the max sum of the pair
        int res = Integer.MIN_VALUE;
        ListNode slow = head, fast = head;
        //head will be at the mid after loop
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;

        //reversing the second half of the node
        ListNode rev = reverseList(slow);

        //finding the max pair sum
        while(head.next!=null){
            res = Math.max(res,rev.val+head.val);
            head = head.next;
            rev = rev.next;
        }
        return res;
    }
    /**Function to reverse the Linked List
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
