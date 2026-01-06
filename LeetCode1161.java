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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        int maxval=Integer.MIN_VALUE;
        int res=1;
        int curr=1;
        while (!que.isEmpty()) {
            int c=0;
            int s=que.size();
            for (int i=0;i<s;i++) {
                TreeNode temp=que.remove();
                c+=temp.val;
                if (temp.left!=null) que.add(temp.left);
                if (temp.right!=null) que.add(temp.right);
            }
            if (c>maxval) {
                maxval=c;
                res=curr;
            }
            curr+=1;
        }
        return res;
    }
}
