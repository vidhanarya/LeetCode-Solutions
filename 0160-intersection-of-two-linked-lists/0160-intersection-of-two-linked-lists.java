/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int heightA = getHeight(headA);
        int heightB = getHeight(headB);
        while (heightA > heightB) {
            headA = headA.next;
            heightA--;
        }

        while (heightB > heightA) {
            headB = headB.next;
            heightB--;
        }

        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public int getHeight(ListNode head) {
        int height = 0;
        while (head != null) {
            head = head.next;
            height++;
        }
        return height;
    }
}