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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        int n = getSize(head);
        n = n - n % k;

        ListNode prev = null, result = null, curr = head;
        while (n > 0) {
            ListNode[] reversed = reverseK(curr, k);
            ListNode h = reversed[0], t = reversed[1];
            if (prev != null) prev.next = h;
            if (result == null) result = h;

            prev = t;
            curr = t.next;
            n -= k;
        }

        return result;
    }

    private ListNode[] reverseK(ListNode head, int k) {
        ListNode prev = null, curr = head;
        while (k-- > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head.next = curr;
        return new ListNode[]{prev, head};
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }
}