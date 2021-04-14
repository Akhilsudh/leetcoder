class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}

public class ReverseNodesInkGroup {
    public ListNode3 reverseKGroup(ListNode3 head, int k) {
        return recursiveFunction(head, k);
    }
    public ListNode3 recursiveFunction(ListNode3 node, int k) {
        if(node == null) {
            return node;
        }
        int count = 0;
        ListNode3 temp = node;
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
        ListNode3 destination = recursiveFunction(temp, k);
        ListNode3 current = node;
        while(current != temp) {
            ListNode3 ahead = current.next;
            current.next = destination;
            destination = current;
            current = ahead;
        }
        return destination;
    }
}