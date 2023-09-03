package LinkedList;
//876. Middle of the Linked List
/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        ListNode mid = middleNode(head);
        System.out.println(mid.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast= new ListNode(), slow = new ListNode();
        fast.next = head; slow.next = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
