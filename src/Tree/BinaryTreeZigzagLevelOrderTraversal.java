package Tree;

import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal
/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        boolean flag=true;
        while(!queue.isEmpty()){
            int size = queue.size();
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> curr = new ArrayList<>();
            while(size-->0){
                TreeNode node = queue.poll();
                if(flag){
                    curr.add(node.val);
                }else{
                    stack.push(node);
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

            }
            while(!stack.isEmpty()){
                curr.add(stack.pop().val);
            }
            res.add(new ArrayList<>(curr));
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] input = new int[]{1,2,2,3,4,4,3};
        tree.root = tree.insertLevelOrder(input,0);
        System.out.printf("The zigzag level order traversal of its nodes' values is %s",zigzagLevelOrder(tree.root));
    }
}
