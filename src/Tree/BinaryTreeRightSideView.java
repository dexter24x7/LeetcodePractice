package Tree;
//199. Binary Tree Right Side View
/*

Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int rightMost =0;
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode curr = q.poll();
                rightMost = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(rightMost);
        }
        return res;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] input = new int[]{1,2,3,0,5,0,4,2};
        bt.root = bt.insertLevelOrder(input,0);
        System.out.println(rightSideView(bt.root));
    }
}
