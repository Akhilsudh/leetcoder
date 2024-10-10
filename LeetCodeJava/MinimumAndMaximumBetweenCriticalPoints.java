import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAndMaximumBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        int[] res = new int[] {-1, -1};
        List<Integer> listCritical = new ArrayList<Integer>();
        int index = 0;
        while(current != null) {
            index++;
            if(current.next != null &&
                    ((current.val > prev.val && current.val > current.next.val) ||
                            (current.val < prev.val && current.val < current.next.val))) {
                listCritical.add(index);
            }
            prev = current;
            current = current.next;
        }
        if(listCritical.size() < 2) {
            return res;
        }
        int min = Integer.MAX_VALUE;
        int max = listCritical.get(listCritical.size() - 1) - listCritical.get(0);
        for(int i = 0; i < listCritical.size() - 1; i++) {
            int temp = listCritical.get(i+1) - listCritical.get(i);
            min = Math.min(temp, min);
        }
        res[0] = min;
        res[1] = max;
        return res;
    }

    public static void main(String[] args) {
        MinimumAndMaximumBetweenCriticalPoints obj = new MinimumAndMaximumBetweenCriticalPoints();
        int[] arr1 = new int[] {4,2,4,1};
        ListNode h1 = new ListNode();
        ListNode temp = h1;
        for(int num: arr1) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        int[] res = obj.nodesBetweenCriticalPoints(h1.next);
        System.out.println(Arrays.toString(res));
    }
}
