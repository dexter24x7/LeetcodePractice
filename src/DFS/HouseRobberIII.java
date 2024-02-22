package DFS;
//337. House Robber III
/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses
in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken
into on the same night.
Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int robRoot = root.val + left[1] + right[1];
        int skipRoot = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{robRoot, skipRoot};
    }
    public static class TreeNode {
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

    public static void main(String[] args) {
        HouseRobberIII solution = new HouseRobberIII();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        int maxAmount = solution.rob(root);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }
}
