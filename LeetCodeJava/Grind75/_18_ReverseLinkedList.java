package Grind75;

public class _18_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode temp = curr;
        prev.next = null;
        while(curr != null) {
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        _18_ReverseLinkedList obj = new _18_ReverseLinkedList();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode res = obj.reverseList(root);
        System.out.println(res.val);
    }
}
