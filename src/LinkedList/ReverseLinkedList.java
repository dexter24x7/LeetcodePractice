package LinkedList;
//206. Reverse Linked List
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr=temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        head = reverseList(head); //nth element from end deleted
        //printing updated list
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
