// 617. Merge Two Binary Trees - https://leetcode.com/problems/merge-two-binary-trees/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Merge binary trees into first binary tree (root1)
class Solution {
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null)
            return root2;
        Stack <TreeNode []> stack = new Stack<>();
        stack.push(new TreeNode[] {root1, root2}); // Traverse them together
        while (!stack.isEmpty()) {
            TreeNode[] node = stack.pop();
            if (node[1] == null)
                continue;
            
            node[0].val += node[1].val; // Merging for each pop operation
            
            if (node[0].left == null)
                node[0].left = node[1].left; 
                // If one of them is null connect the second tree to first one, 
                // you are actually doing null + second tree = second tree, you do not need to push them into stack since you will not merge any value
            else
                stack.push(new TreeNode[] {node[0].left, node[1].left});
            
            if (node[0].right == null)
                node[0].right = node[1].right;
            else
                stack.push(new TreeNode[] {node[0].right, node[1].right});
        }
        return root1;
    }
}

class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}