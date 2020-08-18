class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        int counter = 1;
        boolean flag = true;
        while(a.next != null) {
            a = a.next;
            counter++;
        }
        System.out.println(counter);
        if(counter == n) {
            return head = head.next;
        }
        a = head;
        for(int i = 0; i < counter - n - 1; i++) {
            a = a.next;
        }
        a.next = a.next.next;
        return head;
    }
}