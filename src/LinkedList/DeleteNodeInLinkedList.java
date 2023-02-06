package LinkedList;//237. Delete Node in a Linked List
/*
There is a singly-linked list head and we want to delete a node "node" in it.
You are given the node to be deleted node. You will not be given access to the first node of head.
All the values of the linked list are unique, and it is guaranteed that the given node "node" is not the last node in the linked list.
Delete the given node. Note that by deleting the node, we do not mean removing it from memory.
We mean:
The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.
 */

public class DeleteNodeInLinkedList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int delete = 4;
        //creating linked list
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        //deleting "delete" from linked list
        ListNode node = head;
        while (node!=null){
            if (node.val==delete)
                deleteNode(node);
            node = node.next;
        }
        //printing Linked list
        curr = head;
        while (curr!=null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
