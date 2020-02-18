/**
* In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
* We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
* Return true if and only if it is possible to reach the target square through a sequence of moves.
*/

class escapeALargeMaze {
    
    int num = 1000000;
    int max = 0;
    
    HashSet<String> h;
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        if(blocked.length==0)
            return true;
       
        h = new HashSet<>();
   
        for(int[] a:blocked)
        {
           h.add("" + a[0]*100 + a[1]);
        }
        max = blocked.length;
        
        if(h.contains("" + source[0]*100 + source[1])||h.contains("" + target[0]*100 + target[1]))
            return false;
        
        
        return helper(source,target); //&& helper(target,source);
        
    }
    
    boolean helper(int[] source,int[] target)
    {
        Queue<int[]> q = new LinkedList<int[]>();
        HashSet<String> m = new HashSet<>();
        q.add(source);
        m.add(""+(source[0])*100+source[1]);
        int len = 0;
        
        while(!q.isEmpty())
        {
            int s = q.size();
            
            for(int i=0;i<s;i++)
            {
                int[] a = q.poll();
                
                if(a[0]==target[0] && a[1]==target[1])
                    return true;
                
                if(a[0]-1>=0 && !m.contains("" + (a[0]-1)*100 + a[1]) && !h.contains("" + (a[0]-1)*100 + a[1]))
                {
                    m.add("" + (a[0]-1)*100 + a[1]);
                    q.add(new int[]{a[0]-1,a[1]});
                }
                
                if(a[0]+1<=num && !m.contains("" + (a[0]+1)*100 + a[1]) && !h.contains("" + (a[0]+1)*100 + a[1]))
                {
                    m.add("" + (a[0]+1)*100 + a[1]);
                    q.add(new int[]{a[0]+1,a[1]});
                }
                
                if(a[1]-1>=0 && !m.contains(""+a[0]*100+(a[1]-1)) && !h.contains(""+a[0]*100+(a[1]-1)))
                {
                    m.add(""+a[0]*100+(a[1]-1));
                    q.add(new int[]{a[0],a[1]-1});
                }
                
                 if(a[1]+1<=num && !m.contains(""+a[0]*100+(a[1]+1)) && !h.contains(""+a[0]*100+(a[1]+1)))
                {
                    m.add(""+a[0]*100+(a[1]+1));
                    q.add(new int[]{a[0],a[1]+1});
                }
                
            }
            
            len++;
            if(len>max)
                return true;
        }
        
        return false;
    }
}
