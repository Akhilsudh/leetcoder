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
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while(l1 != null && l2 != null) {
            temp.next = new ListNode();
            temp = temp.next;
            if(l1.val <= l2.val) {
                temp.val = l1.val;
                l1 = l1.next;
            }
            else {
                temp.val = l2.val;
                l2 = l2.next;
            }
        }
        while(l1 != null) {
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = l1.val;
            l1 = l1.next;
        }
        while(l2 != null) {
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = l2.val;
            l2 = l2.next;
        }
        return head.next;
    }
}