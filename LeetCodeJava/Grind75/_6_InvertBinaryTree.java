package Grind75;

public class _6_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    private void invertTreeHelper(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTreeHelper(node.left);
        invertTreeHelper(node.right);
    }

    public static void main(String[] args) {
        _6_InvertBinaryTree obj = new _6_InvertBinaryTree();
        // 4,2,7,1,3,6,9
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        obj.invertTree(root1);
        System.out.println(root1.val);
    }
}
