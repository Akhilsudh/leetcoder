package Grind75;

import java.util.concurrent.atomic.AtomicInteger;

public class _11_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return travelTree(root) != -1;
    }

    private int travelTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = travelTree(root.left);
        if(left == -1) {
            return -1;
        }
        int right = travelTree(root.right);
        if(right == -1) {
            return -1;
        }
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        _11_Balanced_Binary_Tree obj = new _11_Balanced_Binary_Tree();
        System.out.println(obj.isBalanced(root));
    }
}
