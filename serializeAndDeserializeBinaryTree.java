/**
* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
* in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another
* computer environment.
*
* Design an algorithm to serialize and deserialize a binary tree.
* There is no restriction on how your serialization/deserialization algorithm should work.
* You just need to ensure that a binary tree can be serialized to a string and this string
* can be deserialized to the original tree structure.
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
 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
         
	        if(root==null)
	        {
	            return "[null]";
	        }
	        
	        ArrayList<String> list = new ArrayList<>();
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        
	        q.add(root);
	        
	        while(!q.isEmpty())
	        {
	            int s = q.size();
	            
	            for(int i=0;i<s;i++)
	            {
	                TreeNode temp = q.poll();
	                
	                if(temp==null)
	                {
	                    list.add("null");
	                    continue;
	                }
	                
	                list.add(""+temp.val);
	                
	                q.add(temp.left);
	                q.add(temp.right);
	                
	            }
	        }
	        
	        return ""+list; 
    
            
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
     
          if(data.equals("[null]"))
	            return null;
	        
	        data = data.substring(1,data.length()-1);
	        
	        String[] arr = data.split(",");
	        
	        int i = 0;
	        TreeNode root = new TreeNode(Integer.parseInt(arr[i++].trim()));
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        
	        q.add(root);
	        
	        while(!q.isEmpty())
	        {
	        	int s = q.size();
	        	
	        	for(int j=0;j<s;j++)
	        	{
	        		TreeNode temp = q.poll();
	        		
	        		String s2 = arr[i++].trim();
	        		String s3 = arr[i++].trim();
	        		
	        		if(!s2.equals("null"))
	        		{
	        			temp.left = new TreeNode(Integer.parseInt(s2));
	        			q.add(temp.left);
	        		}
	        		
	        		
	        		if(!s3.equals("null"))
	        		{
	        			temp.right = new TreeNode(Integer.parseInt(s3));
	        			q.add(temp.right);
	        		}
	        	}
	        }
	        
	        return root;
        
    }
  
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
