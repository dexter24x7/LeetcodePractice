//19. Remove Nth Node From End of List
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class RemoveNtNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2};
        int n= 2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        head = removeNthFromEnd(head,n); //nth element from end deleted
        //printing updated list
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n){
        //check for 0 size linked list - not required as per the constraints
        if (head == null) return null;
        ListNode fastNode=head.next, currNode=head; //currNode is 1 step behind fastNode initially
        //moves fast node n places ahead
        for (int i =0;i<n;i++){
            if (fastNode==null) return null; //if the list is smaller than n return null
            fastNode = fastNode.next;
        }
        //finding the (n+1)th node from end
        while (fastNode!=null){ //when fastNode is at end currNode is at (n+1)th node from end
            fastNode = fastNode.next;
            currNode = currNode.next;
        }
        currNode.next= currNode.next.next; //deleting the nth node from end
        return head;
    }
}
