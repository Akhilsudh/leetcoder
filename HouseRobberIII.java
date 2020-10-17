/*  https://leetcode.com/problems/house-robber-iii/
    The thief has found himself a new place for his thievery again. There is only one 
    entrance to this area, called the "root." Besides the root, each house has one and 
    only one parent house. After a tour, the smart thief realized that "all houses in 
    this place forms a binary tree". It will automatically contact the police if two 
    directly-linked houses were broken into on the same night. Determine the maximum 
    amount of money the thief can rob tonight without alerting the police.

    Example 1:
        Input: [3,2,3,null,3,null,1]
              3
             / \
            2   3
             \   \
              3   1
        Output: 7 
        Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    Example 2:
    Input: [3,4,5,1,3,null,1]
              3
             / \
            4   5
           / \   \
          1   3   1
    Output: 9
    Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
public class HouseRobberIII {
    public int rob(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        else {
            int result1 = 0;
            if(node.left != null) {
                result1 += dfs(node.left.left) + dfs(node.left.right);
            }
            if(node.right != null) {
                result1 += dfs(node.right.left) + dfs(node.right.right);
            }
            result1 += node.val;
            int result2 = dfs(node.left) + dfs(node.right);
            return Math.max(result1, result2);
        }
    }
}
