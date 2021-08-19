/*  https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
    Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
    Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
    Note that you need to maximize the answer before taking the mod and not after taking it.
    Example 1:
      Input: root = [1,2,3,4,5,6]
      Output: 110
      Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
    Example 2:
      Input: root = [1,null,2,3,4,null,null,5,6]
      Output: 90
      Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
      Input: root = [1,null,2,3,4,null,null,5,6]
    Example 3:
      Input: root = [2,3,9,10,7,8,6,5,4,11,1]
      Output: 1025
    Example 4:
      Input: root = [1,1]
      Output: 1
*/

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MaximumProductOfSplittedBinaryTree {
  public int maxProduct(TreeNode root) {
      Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
      generateSumAtNodes(root, map);
      return getMaxProduct(map, root);
  }

  Integer generateSumAtNodes(TreeNode node, Map<TreeNode, Integer> map) {
      Integer left = 0;
      Integer right = 0;
      
      if(node.left != null) {
          left = generateSumAtNodes(node.left, map);
      }
      if(node.right != null) {
          right = generateSumAtNodes(node.right, map);
      }
      map.put(node, node.val + left + right);
      return map.get(node);
  }

  int getMaxProduct(Map<TreeNode, Integer> map, TreeNode root) {
      long max = 0;
      long mod=(long) 1e9+7;
      long total = map.get(root);
      for(TreeNode node: map.keySet()) {  
        max = Math.max((map.get(node) * (total - map.get(node))), max);
      }
      return (int)(max % mod);
  }
}