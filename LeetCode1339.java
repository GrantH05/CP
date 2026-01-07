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
    long res=Integer.MIN_VALUE;
    long tot;
    private int traverse(TreeNode temp) {
        int p=0,q=0;
        if (temp.left!=null) p=traverse(temp.left);
        if (temp.right!=null) q=traverse(temp.right);
        return p+q+temp.val;
    }
    private int traverseSum(TreeNode tempp) {
        int p=0,q=0;
        if (tempp.left!=null) p=traverseSum(tempp.left);
        if (tempp.right!=null) q=traverseSum(tempp.right);
        int curr=p+q+tempp.val;
        res=Math.max(res,curr*(tot-curr));
        return curr;
    }
    public int maxProduct(TreeNode root) {
        tot=traverse(root);
        int tryy=traverseSum(root);
        return (int)(res%(1000000007L));
    }
}