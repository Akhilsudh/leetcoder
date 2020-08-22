import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        return recursiveFunction(head, k);
    }
    public ListNode recursiveFunction(ListNode node, int k) {
        if(node == null) {
            return node;
        }
        int count = 0;
        ListNode temp = node;
        for(int i = 0; i < k; i++) {
            if(temp == null) {
                break;
            }
            temp = temp.next;
            count++;
        }
        if(count != k) {
            return node;
        }
        ListNode destination = recursiveFunction(temp, k);
        ListNode current = node;
        while(current != temp) {
            ListNode ahead = current.next;
            current.next = destination;
            destination = current;
            current = ahead;
        }
        return destination;
    }
}