package LinkedList;
//83. Remove Duplicates from Sorted List
/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.next.val == curr.val){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        System.out.println(deleteDuplicates(head));
    }
}
