package LinkedList;

//160. Intersection of Two Linked Lists
/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.
Note that the linked lists must retain their original structure after the function returns.
 */
public class IntersectionOfTwoLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        //LinkedList A
        int[] arrA = {1,2,3,4,5,6};
        ListNode headA = new ListNode(-1);
        ListNode curr = headA;
        for (int j : arrA) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        //LinkedListB
        int[] arrB = {2,3};
        ListNode headB = new ListNode(-1);
        curr = headB;
        for (int j : arrB) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        ListNode intersection = getIntersectionNode(headA,headB);
        System.out.println(intersection);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int sizeA, sizeB;
         //getting the size of both lined lists
         sizeA= getListSize(headA);
         sizeB= getListSize(headB);
         //shifting ahead the head pointer of the longer array by the difference of sizes
         if (sizeA>sizeB) {
             for (int i = 0; i < sizeA - sizeB; i++)
                 headA = headA.next;
         }
         else {
             for (int i = 0; i < sizeB - sizeA; i++)
                 headB = headB.next;
         }
         //traverse both the linked lists simultaneously till intersection is found
         while (headA!=null){
             if (headA==headB) //same element in both the lists
                 return headA; //intersecting node returned
             headA = headA.next;
             headB = headB.next;
         }
         return null; //no intersection found
    }
    //function to return the size of any linked list
    public static int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    //Approach 2
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode skipA =headA;
        ListNode skipB =headB;
        /*
        Intuition: if each pointer traverse twice on both lists they will meet together at end or at meeting point.
         */
        while(true){
            if(skipA ==null) skipA=headB;
            if(skipB ==null) break;
            skipA = skipA.next;
            skipB = skipB.next;
        }
        skipB=headA;
        while(true){
            if(skipA ==null) skipA=headB;
            if(skipB==null) break;
            if(skipB ==skipA) break;
            skipA = skipA.next;
            skipB = skipB.next;
        }
        return skipB;
    }
}
