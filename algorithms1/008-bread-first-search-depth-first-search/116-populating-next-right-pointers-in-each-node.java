// 116. Populating Next Right Pointers in Each Node - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// Go level by level (leftmost node), for each level go one by one to the next
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node leftNode = root;
        while(leftNode != null) {
            Node head = leftNode;
            while(head != null) {
                if (head.left != null)
                    head.left.next = head.right;
                if (head.left != null && head.next != null)
                    head.right.next = head.next.left;
                head = head.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
}

// DFS Approach
class Solution2 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        dfs(root);
        return root;
    }
    public void dfs(Node root) {
        if (root == null)
            return;
        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;
        dfs(root.left);
        dfs(root.right);
    }
}