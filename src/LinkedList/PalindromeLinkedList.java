package LinkedList;
//234. Palindrome Linked List
/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        ListNode slow = head, fast = head;
        //head will be at the mid after loop
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reversing the second half of the node
        ListNode prev = slow;
        slow = slow.next;
        prev.next=null;

        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        fast = head;
        slow = prev;

        //checking palindrome
        while(slow!=null){
            if(slow.val != fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        System.out.println(isPalindrome(head));
    }
}
