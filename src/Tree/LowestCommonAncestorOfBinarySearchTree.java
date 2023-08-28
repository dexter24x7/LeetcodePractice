package Tree;
//235. Lowest Common Ancestor of a Binary Search Tree
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a
descendant of itself).”
 */
public class LowestCommonAncestorOfBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val >= p.val && root.val<= q.val) return root;
        else if(root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else if(root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{6,2,8,0,4,7,9,3,5};
        bt.root = bt.insertLevelOrder(input,0);
        TreeNode p = new TreeNode(2), q = new TreeNode(4);
        System.out.println("LCA of p & q is: "+lowestCommonAncestor(bt.root,p,q).val);
    }
}
