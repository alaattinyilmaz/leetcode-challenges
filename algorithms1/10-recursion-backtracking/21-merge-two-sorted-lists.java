// 21. Merge Two Sorted Lists - https://leetcode.com/problems/merge-two-sorted-lists/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode mergedList = new ListNode(0);
        ListNode mptr = mergedList;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                mptr.next = list1;
                list1 = list1.next;
            } else {
                mptr.next = list2;
                list2 = list2.next;
            }
            mptr = mptr.next;
        }
        if (list1 != null)
            mptr.next = list1;
        if (list2 != null)
            mptr.next = list2;
        return mergedList.next;
    }
}

// Recursive approach
class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}