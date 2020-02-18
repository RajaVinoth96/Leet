/**
* You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
* 
* 0 represents the obstacle can't be reached.
* 1 represents the ground can be walked through.
* The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
* You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first.
* And after cutting, the original place has the tree will become a grass (value 1).
*
* You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. 
* If you can't cut off all the trees, output -1 in that situation.
*
* You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
*/

class cutOffTreesForGolfEvent {

    public int cutOffTree(List<List<Integer>> forest) {
        
       int m = forest.size();
       int n = forest.get(0).size();
        
        if(forest.get(0).get(0)==0)
            return -1;
        
     PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                int num = forest.get(i).get(j);
                if(num!=0 && num!=1)
                {
                    pq.add(num);
                }
            }
        
        
        if(pq.size()==0)
            return 0;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0,0});
        
        int count = 0;
        
        while(!q.isEmpty())
        {
            int s = q.size();
            boolean flag  = false;
            int num = pq.peek();
            
            for(int i=0;i<s;i++)
            {
                int[] ind = q.poll();
                
                int k = ind[0];
                int l = ind[1];
                
               
                if(forest.get(k).get(l)==num)
                {
                  //  System.out.println("i " +  k + " j " + l);
                  //  System.out.println("count " + count + " pq " + pq.size());
                    if(pq.size()==1)
                        return count;
                    
                    flag = true;
                    pq.poll();
                    visited = new boolean[m][n];
                    q = new LinkedList<>();
                    
                    visited[k][l]=true;
                }
                
                if(k-1>=0 && !visited[k-1][l])
                {
                    if(forest.get(k-1).get(l)!=0)
                    {
                        visited[k-1][l]=true;
                        q.add(new int[]{k-1,l});
                    }
                }
                
                if(k+1<m && !visited[k+1][l])
                {
                    if(forest.get(k+1).get(l)!=0)
                    {
                        visited[k+1][l]=true;
                        q.add(new int[]{k+1,l});
                    }
                }
                
                if(l-1>=0 && !visited[k][l-1])
                {
                    if(forest.get(k).get(l-1)!=0)
                    {
                        visited[k][l-1]=true;
                        q.add(new int[]{k,l-1});
                    }
                }
                
                if(l+1<n && !visited[k][l+1])
                {
                    if(forest.get(k).get(l+1)!=0)
                    {
                        visited[k][l+1]=true;
                        q.add(new int[]{k,l+1});
                    }
                }
                
                if(flag)
                    break;
            }
           
           // System.out.println("here");
            count++;
        }
        
        return -1;
    }
}
