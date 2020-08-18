class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head, b = head;
        for(int i = 0; i < n; i++) {
            b = b.next;
        }
        if(b == null) {
            return head.next;
        }
        while(b.next != null) {
            a = a.next;
            b = b.next;
        }
        a.next = a.next.next;
        return head;
    }
}