package Grind75;

public class _12_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if(slow == null || slow.next == null || fast == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);
        return true;
    }

    public static void main(String[] args) {
        _12_Linked_List_Cycle obj = new _12_Linked_List_Cycle();
        ListNode root1 = new ListNode(3);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(0);
        root1.next.next.next = new ListNode(-4);
        root1.next.next.next.next = root1.next;
        System.out.println(obj.hasCycle(root1));

        ListNode root2 = new ListNode(3);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(0);
        root2.next.next.next = new ListNode(-4);
        System.out.println(obj.hasCycle(root2));
        System.out.println(obj.hasCycle(null));
    }
}
