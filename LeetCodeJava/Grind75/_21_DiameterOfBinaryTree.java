package Grind75;

public class _21_DiameterOfBinaryTree {
    Integer result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        result = Math.max(result, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }

    public static void main(String[] args) {
        _21_DiameterOfBinaryTree obj = new _21_DiameterOfBinaryTree();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(obj.diameterOfBinaryTree(root1));

        TreeNode root2 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(obj.diameterOfBinaryTree(root2));
    }
}
