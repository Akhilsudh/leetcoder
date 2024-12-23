package Grind75;

public class _10_Lowest_Common_Ancestory_Of_A_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val <= root.val && q.val >= root.val) {
            return root;
        } else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p , q);
        }
        return root;
    }
}
