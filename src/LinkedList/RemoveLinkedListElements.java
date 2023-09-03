package LinkedList;
//203. Remove Linked List Elements
/*
Given the head of a linked list and an integer val,remove all the nodes
of the linked list that has Node.val == val, and return the new head.
 */

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        System.out.println(removeElements(head, 4));
    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        //deleting the first elements
        while(head!=null){
            if(head.val==val) head = head.next;
            else break;
        }
        ListNode curr = new ListNode();
        curr.next = head;
        //deleting intermediate elements
        while(curr.next!=null){
            if (curr.next.val == val ){
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return head;
    }
}

