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
        int index = 1;
        while(true) {
            List<Integer> list  = new ArrayList<Integer>();
            printGivenLevel(list, root, index);
            if(list.isEmpty()) {
                break;
            }
            index++;
            result.add(list);
        }
        return result;
    }

    private void printGivenLevel(List<Integer> list, TreeNode root, int level) {
        if(root == null) {
            return;
        }
        else if(level == 1) {
            list.add(root.val);
            return;
        }
        else if(level > 1) {
            printGivenLevel(list, root.left, level - 1);
            printGivenLevel(list, root.right, level - 1);
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        System.out.println(obj.levelOrder(root));
    }
}