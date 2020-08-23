import java.util.Comparator;
import java.util.PriorityQueue;
public class MergeKSortedLists {
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(Comparator.<ListNode>comparingInt(o -> o.val));
}