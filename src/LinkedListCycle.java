import java.util.LinkedList;

//141. Linked List Cycle
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again
by continuously following the next pointer. Internally, pos is used to denote the index of the
node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        System.out.println(hasCycle(head));

    }
    public static boolean hasCycle(ListNode head) {
        int size=0;
        ListNode curr = head;
        while (curr.next!=null){
            curr = curr.next;
            size++;
        }
        ListNode pos = curr;
        curr = head;
        while (curr.next!=null){
            if (curr==pos.next)
                return true;
            curr = curr.next;
        }
        return false;
    }
}
