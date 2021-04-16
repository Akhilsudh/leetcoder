#     https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
#     Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that 
#     every key of the original BST is changed to the original key plus sum of all keys greater 
#     than the original key in BST. As a reminder, a binary search tree is a tree that 
#     satisfies these constraints:
#         1. The left subtree of a node contains only nodes with keys less than the node's key.
#         2. The right subtree of a node contains only nodes with keys greater than the node's key.
#         3. Both the left and right subtrees must also be binary search trees.
#     Example:
#         https://assets.leetcode.com/uploads/2019/05/02/tree.png
#         Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
#         Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
#
from TreeNode import TreeNode

class BinarySearchTreeToGreaterSumTree:
  sum: int = 0

  def bstToGst(self, root: TreeNode) -> TreeNode:
    if(root == None):
      return None
    self.bstToGst(root.right)
    root.val += self.sum
    self.sum = root.val
    self.bstToGst(root.left)
    return root