#   https://leetcode.com/problems/add-two-numbers/
#   You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, 
#   and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
#   You may assume the two numbers do not contain any leading zero, except the number 0 itself.
#   Example 1:
#       Input: l1 = [2,4,3], l2 = [5,6,4]
#       Output: [7,0,8]
#       Explanation: 342 + 465 = 807.
#   Example 2:
#       Input: l1 = [0], l2 = [0]
#       Output: [0]
#   Example 3:
#       Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
#        Output: [8,9,9,9,0,0,0,1]

from ListNode import ListNode

class AddTwoNumbers:
  def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
    result = ListNode()
    self.sumLists(l1, l2, result, 0)
    return result if (result.next == None) else result.next

  def sumLists(self, l1: ListNode, l2: ListNode, result: ListNode, carry: int):
    r = result
    a = l1.val if (l1 != None) else 0
    b = l2.val if (l2 != None) else 0
    sum = a + b
    if(l1 == None and l2 == None and carry == 0):
      r.next = None
    else:
      r.next = ListNode((a + b + carry) % 10)
      r = r.next
      l1 = l1.next if (l1 != None) else None
      l2 = l2.next if (l2 != None) else None
      self.sumLists(l1, l2, r, (a + b + carry) // 10)

  def createListNode(self, list: list) ->  ListNode:
    result = ListNode()
    temp = result
    for item in list:
      temp.next = ListNode()
      temp = temp.next
      temp.val = item
    return result if (result.next == None) else result.next

  def printNumber(self, node: ListNode) -> str:
    result = ""
    while(node != None):
      result = str(node.val) + result
      node = node.next;
    return result
 
def main():
  obj = AddTwoNumbers()
  l1 = [2,4,3]
  l2 = [5,6,4]
  result = obj.addTwoNumbers(obj.createListNode(l1), obj.createListNode(l2))
  print("Solution 1 = " + obj.printNumber(result))
  l1 = [9,9,9,9,9,9,9]
  l2 = [9,9,9,9]
  result = obj.addTwoNumbers(obj.createListNode(l1), obj.createListNode(l2))
  print("Solution 2 = " + obj.printNumber(result))

if __name__ == "__main__":
  main()
