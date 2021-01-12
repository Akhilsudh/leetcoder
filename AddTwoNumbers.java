/*  https://leetcode.com/problems/add-two-numbers/
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, 
    and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
    Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]
    Example 3:
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
*/

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
        ListNode result = new ListNode();
        result.val = 0;
        addListNodes(l1, l2, result, 0);
        return (result.next == null) ? result : result.next;
    }

    void addListNodes(ListNode l1, ListNode l2, ListNode result, int carry) {
        int a = (l1 != null) ? l1.val : 0;
        int b = (l2 != null) ? l2.val : 0;
        if(l1 == null && l2 == null && carry == 0) {
            result.next = null;
        }
        else {
            result.next = new ListNode();
            result = result.next;
            result.val = (a + b + carry) % 10;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            addListNodes(l1, l2, result, (a + b + carry) / 10);
        }
        return;
    }

    ListNode createListNodes(String number) {
        ListNode list = new ListNode();
        ListNode temp = list;
        for(int i = number.length() - 1; i >= 0; i--) {
            temp.next = new ListNode(Integer.parseInt(number.charAt(i) + ""));
            temp = temp.next;
        }
        return list.next;
    }

    void printNumber(ListNode list) {
        String result = "";
        while(list != null) {
            result = list.val + result;
            list = list.next;
        }
        System.out.println(result);
        return;
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode l1 = obj.createListNodes("342");
        ListNode l2 = obj.createListNodes("465");
        obj.printNumber(obj.addTwoNumbers(l1, l2));
        l1 = obj.createListNodes("9999999");
        l2 = obj.createListNodes("9999");
        obj.printNumber(obj.addTwoNumbers(l1, l2));d
    }

}