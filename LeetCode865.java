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
class Solution {
    int maxDepth=0;
    int nodeCount=0;
    int nc=0;
    int low=-1;
    boolean found=false;
    TreeNode res;
    private void findDepth(TreeNode temp, int n) {
        if (n==maxDepth) nodeCount+=1;
        else if (n>maxDepth) {
            maxDepth=n;
            nodeCount=1;
        }
        if (temp.left!=null) findDepth(temp.left, n+1);
        if (temp.right!=null) findDepth(temp.right, n+1);
    }
    private void check(TreeNode temp, int n) {
        if (found) return;
        if (temp.left!=null) check(temp.left, n+1);
        if (temp.right!=null) check(temp.right, n+1);
        if (n==maxDepth) {
            nc+=1;
        }
        if (nc==nodeCount) found=true;
    }
    private void find(TreeNode temp, int n) {
        nc=0;
        found=false;
        check(temp, n);
        if (found && n>low) res=temp;
        if (temp.left!=null) find(temp.left, n+1);
        if (temp.right!=null) find(temp.right, n+1);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findDepth(root,0);
        find(root,0);
        return res;
    }
}