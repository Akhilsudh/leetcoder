
public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode result = new ListNode();
        ListNode temp = result;
        head = head.next;
        while(head != null) {
            int value = head.val;
            head = head.next;
            if(value == 0) {
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            } else {
                sum += value;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        MergeNodesInBetweenZeros obj = new MergeNodesInBetweenZeros();
        ListNode head = new ListNode();
        ListNode temp = head;
        int[] arr = new int[] {0,3,1,0,4,5,2,0};
        for(int i: arr) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode result = obj.mergeNodes(head.next);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
