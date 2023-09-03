package LinkedList;
//1290. Convert Binary Number in a Linked List to Integer
/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number. Return the decimal value of the number in the linked list.
The most significant bit is at the head of the linked list.
 */
public class BinaryInLinkedListToInteger {
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int j : arr) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        System.out.println(getDecimalValue(head.next));
        System.out.println(getDecimalValue2(head.next));
        System.out.println(Integer.parseInt("100100111000000",2));
    }
    //Approach 1
    public static int getDecimalValue(ListNode head) {
        StringBuilder binaryNumber = new StringBuilder();
        //retrieve binary number from Linked List
        while (head!=null){
            binaryNumber.append(head.val);
            head = head.next;
        }
       return Integer.parseInt(binaryNumber.toString(),2);
    }
    //Approach 2
    public static int getDecimalValue2(ListNode head) {
        int decimalNumber = 0;
        while (head!=null){
            decimalNumber = decimalNumber*2+head.val;
            head = head.next;
        }
        return decimalNumber;
    }
}
