package LinkedList;

//141. Linked List Cycle
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again
by continuously following the next pointer. Internally, pos is used to denote the index of the
node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        curr.next = head.next; //linked the last node to first node to make linked list cyclic
        System.out.println(hasCycle(head));//passing the head to check if cycle exists in the Linked list

    }
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next==null) return false; //for 0 node LL and 1 node non-cyclic LL
        ListNode fastPtr = head.next.next, slowPtr= head.next; //slowPointer at first element and fastPointer at second element
        while (fastPtr!=null && fastPtr.next!=null){ //check if fastPointer has reached the end of linked-list
            //if the fastPointer is equal or behind the slowPointer it must have cycled once
            if (fastPtr==slowPtr || fastPtr.next==slowPtr)
                return true;
            slowPtr = slowPtr.next; //1x speed
            fastPtr = fastPtr.next.next; //2x speed
        }
        return false; //fastPointer has reached the end of linked-list
    }
}
