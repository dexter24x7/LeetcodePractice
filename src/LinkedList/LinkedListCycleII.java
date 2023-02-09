package LinkedList;
//142. Linked List Cycle II
/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.
 */

public class LinkedListCycleII {
    //user defined linked-list class
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        curr.next = head.next; //linked the last node to first node to make linked list cyclic
        System.out.println(detectCycle(head));//passing the head to check if cycle exists in the Linked list

    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null; //for 0 node LL and 1 node non-cyclic LL
        ListNode fastPtr = head.next.next, slowPtr = head.next; //slowPointer at first element and fastPointer at second element
        while (fastPtr != null && fastPtr.next != null) { //check if fastPointer has reached the end
            if (fastPtr == slowPtr) {
                fastPtr = head;
                while (slowPtr != null) {
                    if (fastPtr == slowPtr)
                        return slowPtr;
                    fastPtr = fastPtr.next;
                    slowPtr = slowPtr.next;
                }
            }
            slowPtr = slowPtr.next; //1x speed
            fastPtr = fastPtr.next.next; //2x speed
        }

        return null;//fastPointer has reached the end of linked-list
    }
}
