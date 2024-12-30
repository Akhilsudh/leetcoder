package Grind75;

import java.util.*;

public class _31_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                        nextQueue.offer(node.left);
                if(node.right != null)
                    nextQueue.offer(node.right);
            }
            result.add(list);
            queue = nextQueue;
        }
        return result;
    }

    public static void main(String[] args) {
        _31_BinaryTreeLevelOrderTraversal obj = new _31_BinaryTreeLevelOrderTraversal();

        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(obj.levelOrder(root1));

        TreeNode root2 = new TreeNode(1);
        System.out.println(obj.levelOrder(root2));

        System.out.println(obj.levelOrder(null));
    }
}
