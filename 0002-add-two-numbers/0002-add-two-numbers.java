/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = new ListNode(-1);

        int carry = 0;
        while (l1 != null && l2 != null) {
            Pair<ListNode, Integer> pair = add(l1.val, l2.val, carry);
            curr.next = pair.getKey();
            curr = curr.next;
            carry = pair.getValue();
            if (head == null) {
                head = curr;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            Pair<ListNode, Integer> pair = add(l1.val, 0, carry);
            curr.next = pair.getKey();
            curr = curr.next;
            carry = pair.getValue();
            l1 = l1.next;
        }

        while (l2 != null) {
            Pair<ListNode, Integer> pair = add(0, l2.val, carry);
            curr.next = pair.getKey();
            curr = curr.next;
            carry = pair.getValue();
            l2 = l2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return head;
    }

    private Pair<ListNode, Integer> add(int val1, int val2, int carry) {
        int sum = val1 + val2 + carry;
        return new Pair<>(new ListNode(sum % 10), sum / 10);
    }
}