//24. Swap Nodes in Pairs
/*
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        swapPairs(head);
        while(head!=null) {
            System.out.println(head.next.val);
            head = head.next;
        }
    }
    public static void swapPairs(ListNode head) {
        ListNode prev = head, first, second;

        while (prev != null && prev.next!=null ){
            first = prev.next;
            second = prev.next.next;
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;
            prev.next = second;
            prev = prev.next.next;
        }
    }
}
