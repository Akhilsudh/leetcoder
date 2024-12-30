package Grind75;

public class _23_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        _23_MaximumDepthOfBinaryTree obj = new _23_MaximumDepthOfBinaryTree();
        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(obj.maxDepth(root1));

        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(obj.maxDepth(root2));
    }
}
