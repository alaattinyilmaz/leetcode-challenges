// 19. Remove Nth Node From End of List - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        int nodeCount = 0;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            nodeCount++;
        }
        if(nodeCount == n)
            return head.next;
        for (int i = 0; i < nodeCount-n-1; i++)
            slowPtr = slowPtr.next;
        if(slowPtr != null)
            slowPtr.next = slowPtr.next.next;
        return head;
    }
}