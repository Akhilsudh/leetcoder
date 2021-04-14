import java.util.Comparator;
import java.util.PriorityQueue;
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
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(Comparator.<ListNode>comparingInt(obj -> obj.val));
        for(ListNode item: lists) {
            if(item != null) {
                pq.add(item);
            }
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode poll = pq.poll();
        while(poll != null) {
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = poll.val;
            if(poll.next != null) {
                pq.add(poll.next);
            }
            poll = pq.poll();
        }
        return head.next;
    }
}