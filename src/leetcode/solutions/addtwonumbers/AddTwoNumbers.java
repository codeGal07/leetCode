package leetcode.solutions.addtwonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;

        int sum = 0;
        while (l1 != null || l2 != null) {

            if (l1 != null) {
                sum = l1.val + sum;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = l2.val + sum;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            current = current.next;
            sum = sum / 10;

        }

        // overflow
        if (sum > 0) {
            current.next = new ListNode(1);
        }
        return result.next;
    }


    public static void main(String args[]) {
//        ListNode one = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode two = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode one = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode two = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        AddTwoNumbers s1 = new AddTwoNumbers();
        ListNode result = s1.addTwoNumbers(one, two);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;


        }
    }
}