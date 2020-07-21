
 // Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digit1 = 0, digit2 = 0, sum = 0, carry = 0;
        ListNode sumList = new ListNode(), lastRef = null, ref = sumList;
        while((l1 != null) || (l2 != null) || (carry != 0)) {
            digit1 = 0; digit2 = 0;
            if(l1 != null) {
                digit1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                digit2 = l2.val;
                l2 = l2.next;
            }
            sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ref.val = sum;
            lastRef = ref;
            ref.next = new ListNode();
            ref = ref.next;
        }
        if(ref.val == 0) {
            lastRef.next = null;
        }
        return sumList;
    }
}