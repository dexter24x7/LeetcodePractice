package Tree;
//236. Lowest Common Ancestor of a Binary Tree
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorOfBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return isPresent(root,p,q);
    }
    static TreeNode isPresent(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = isPresent(root.left,p,q);
        TreeNode right = isPresent(root.right,p,q);
        if(left != null && right != null)  return root;
        else if(left==null) return right;
        else return left;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{1,2};
        bt.root = bt.insertLevelOrder(input,0);

        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode ans = lowestCommonAncestor(bt.root,p,q);
        System.out.println(ans);
    }
}
