import java.util.PriorityQueue;

public class SortLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        int[] arr = {2, 5, 6, 3, 7, 1};
        ListNode temp = root;
        for(int num: arr) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }


        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

        temp = root;
        ListNode next = temp;
        while(temp != null) {
            next = temp.next;
            minHeap.offer(temp);
            temp = next;
        }

        ListNode result = minHeap.poll();
        temp = result;
        while(temp != null) {
            temp.next = minHeap.poll();
            temp = temp.next;
        }


        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
