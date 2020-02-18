/**
* Given a non-empty binary tree, find the maximum path sum.
* For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
* along the parent-child connections. The path must contain at least one node and does not need to go through the root.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class binaryTreeMaximumPathSum {
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
     
        helper(0,root);
        
        return max;
    }
    
    int helper(int cursum , TreeNode node)
    {
        cursum+=node.val;
        max = Math.max(max,cursum);
        
        if(node.left==null && node.right==null)
            return cursum;
        else if(node.left!=null && node.right!=null)
        {
            int left = helper(0,node.left);
            int right = helper(0,node.right);
            
          max = Math.max(max,Math.max(node.val+left,Math.max(node.val+right,node.val+right+left)));
            
            
            return Math.max(cursum,Math.max(cursum+left,cursum+right));
            
        }
        else if(node.left!=null)
        {
            int left = helper(0,node.left);
            max = Math.max(max,node.val+left);
            return Math.max(cursum,cursum+left);
        }
        else
        {
            int right = helper(0,node.right);
            max = Math.max(max,node.val+right);
            return Math.max(cursum,cursum+right);
        }
            
    }
}
