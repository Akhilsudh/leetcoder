/*  https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    Given a binary tree, return the zigzag level order traversal of its nodes' values. 
    (ie, from left to right, then right to left for the next level and alternate between).
    For example:
    Given binary tree [3,9,20,null,null,15,7],
         3
        / \
       9  20
         /  \
        15   7
    return its zigzag level order traversal as:
    [
        [3],
        [20,9],
        [15,7]
    ]
*/
import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        boolean dir = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(size > 0) {
                size--;
                TreeNode top = queue.poll();
                if(top.left != null) {
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
                list.add(top.val);
            }
            if(dir) {
                result.add(list);
            }
            else {
                Collections.reverse(list);
                result.add(list);
            }
            dir = !dir;
        }
        return result;
    }
}
