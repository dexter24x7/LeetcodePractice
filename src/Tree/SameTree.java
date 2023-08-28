package Tree;
//100. Same Tree
/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null) return true;
        if(p==null || q==null || p.val != q.val) return false;
        boolean b1 = isSameTree( p.left , q.left);
        boolean b2 = isSameTree( p.right , q.right);
        return  b1 && b2;
    }

    public static void main(String[] args) {
        BinaryTree p = new BinaryTree();
        int[] input = new int[]{1,2};
        p.root = new TreeNode(input[0]);
        for (int i=1;i< input.length; i++){
            p.insertTreeNode(p.root,input[i]);
        }
        BinaryTree q = new BinaryTree();
        int[] inputSubtree = new int[]{1,2};
        q.root = new TreeNode(inputSubtree[0]);
        for (int i=1;i< input.length; i++){
            q.insertTreeNode(q.root,inputSubtree[i]);
        }
        System.out.println("p & q are same tree: "+isSameTree(p.root,q.root));
    }
}
