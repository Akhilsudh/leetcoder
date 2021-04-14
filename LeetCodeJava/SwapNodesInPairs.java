class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}

public class SwapNodesInPairs {
    public ListNode2 swapPairs(ListNode2 head) {
        return recursiveFunction(head);
    }
    public ListNode2 recursiveFunction(ListNode2 node) {
        if(node == null) {
            return node;
        }
        int count = 0;
        ListNode2 temp = node;
        for(int i = 0; i < 2; i++) {
            if(temp == null) {
                break;
            }
            temp = temp.next;
            count++;
        }
        if(count != 2) {
            return node;
        }
        ListNode2 destination = recursiveFunction(temp);
        ListNode2 current = node;
        while(current != temp) {
            ListNode2 ahead = current.next;
            current.next = destination;
            destination = current;
            current = ahead;
        }
        return destination;
    }
}