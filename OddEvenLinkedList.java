/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

*/
public class OddEvenLinkedList {

    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public void insert(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null;

        ListNode current = head;
        ListNode twoStep = head;
        ListNode prev = head;

        while (twoStep.next != null && twoStep.next.next != null) {

            twoStep = twoStep.next.next;
            current = current.next;
            current.next = twoStep.next;
            twoStep.next = prev.next;
            prev.next = twoStep;

            twoStep = current;

            prev = prev.next;
        }

        this.head = head;
        return this.head;
    }
  public void print() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        list.insert(2);
        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insert(6);
        list.insert(4);
        list.insert(7);
        list.print();
        list.oddEvenList(list.head);
        System.out.println();
        list.print();
    }
}
