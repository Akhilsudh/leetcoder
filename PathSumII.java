/*  https://leetcode.com/problems/path-sum-ii/
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    Note: A leaf is a node with no children.

    Example:
    Given the below binary tree and sum = 22,
           5
          / \
         4   8
        /   / \
       11  13  4
      / \     / \
     7   2   5   1

     Return:
    [
        [5,4,11,2],
        [5,8,4,5]
    ]
*/
import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(root, result, new ArrayList<Integer>(), sum);
        return result;
    }
    private void helper(TreeNode node, List<List<Integer>> result, List<Integer> list, int sum) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        if(sum == node.val && node.left == null && node.right == null) {
            result.add(new ArrayList<Integer>(list));
        }
        helper(node.left, result, list, sum - node.val);
        helper(node.right, result, list, sum - node.val);
        list.remove(list.size() - 1);
    }
}