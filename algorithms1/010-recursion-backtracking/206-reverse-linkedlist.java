// 206. Reverse Linked List - https://leetcode.com/problems/reverse-linked-list/

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode;
        while(currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}

// TODO: Look up for the recursive solution!