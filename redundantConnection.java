/**
* In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for 
* which all other nodes are descendants of this node, plus every node has exactly one parent,
* except for the root node which has no parents.
* The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N),
* with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not 
* an edge that already existed.
* The resulting graph is given as a 2D-array of edges. 
* Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
* Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
* If there are multiple answers, return the answer that occurs last in the given 2D-array.
*/

class redundantConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
         int[] parents = new int[edges.length+1];
         int[] b = new int[]{0,0};
         for(int[] a:edges)
         {
             if(parents[a[1]]!=0)
             {
                 b[0] = a[0];
                 b[1] = a[1];
                 continue;
             }
             parents[a[1]] = a[0];
         }
        
        
        return helper(parents,b,edges);
    }
    
    public int[] helper(int[] parents , int[] b , int[][] edges)
    {
        boolean[] seen = new boolean[edges.length+1];
        
        for(int i=1;i<=edges.length;i++)
        {
            if(parents[i]!=0 && !seen[i])
            {
                if(isMultiple(i,parents,seen,new boolean[edges.length+1]))
                {
                    if(b[0]==0)
                        return new int[]{parents[i],i};
                    else
                        return new int[]{parents[b[1]],b[1]};
                }
            }
        }
        
        return b;
    }
    
    public boolean isMultiple(int i , int[] parents , boolean[] seen , boolean[] vis)
    {
        if(vis[i])
            return true;
        if(seen[i])
            return false;
        seen[i] = true;
        vis[i] = true;
        if(parents[i]!=0)
            return isMultiple(parents[i],parents,seen,vis);
        return false;
    }
}
