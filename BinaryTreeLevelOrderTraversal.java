/*  https://leetcode.com/problems/binary-tree-level-order-traversal/
    Given a binary tree, return the level order traversal of its nodes' values. 
    (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
         3
        / \
       9  20
         / \
        15 7
    return its level order traversal as:
    [
        [3],
        [9,20],
        [15,7]
    ]
*/
import java.util.*;
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
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list  = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);   
                }
                if(temp.right != null) {
                    queue.add(temp.right);   
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        System.out.println(obj.levelOrder(root));
    }
}