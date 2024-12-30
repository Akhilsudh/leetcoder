package Grind75;

public class _22_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null) {
                break;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        _22_MiddleOfTheLinkedList obj = new _22_MiddleOfTheLinkedList();

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        System.out.println(obj.middleNode(node1).val);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);
        System.out.println(obj.middleNode(node2).val);

        ListNode node3 = new ListNode(1);
        System.out.println(obj.middleNode(node3).val);
    }
}
