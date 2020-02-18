/**
* Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four neighbours of it if they exist 
* (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighboors if they share one edge.
* Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.
* Binary matrix is a matrix with all cells equal to 0 or 1 only.
* Zero matrix is a matrix with all cells equal to 0.
*/

class minimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
    public int minFlips(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        if(isZero(mat))
            return 0;
        
        HashSet<String> set = new HashSet<>();
        set.add(val(mat));
        
        Queue<int[][]> q = new LinkedList<>();
        q.add(mat);
        
        int count = 0;
        
        while(!q.isEmpty())
        {
            int s = q.size();
            
            for(int k=0;k<s;k++)
            {
                mat = q.poll();
                
                if(isZero(mat))
                    return count;
                
                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        
                            int[][] tmat = flip(mat,i,j);
                            String seen = val(tmat);
                            //System.out.println(seen);
                            if(!set.contains(seen))
                            {
                                set.add(seen);
                                q.add(tmat);
                            }
                        
                    }
                }
            }
            
            System.out.println(set + " " + count);
            count++;
        }
        
      //  System.out.println(set);
        
        
        return -1;
    }
    
    boolean isZero(int[][] mat)
    {
        for(int[] a:mat)
            for(int b:a)
                if(b==1)
                    return false;
        return true;
    }
    
    String val(int[][] mat)
    {
        String seen = "";
        
        for(int[] a : mat)
            for(int b : a)
                seen = seen+b;
        
        return seen;
    }
    
    int[][] flip(int[][] mat,int i , int j)
    {
        //System.out.println(i + " " + j);
        //System.out.println(val(mat));
        
        int[][] tmat = new int[mat.length][];
        
        for(int k=0;k<mat.length;k++)
            tmat[k] = mat[k].clone();
        
        tmat[i][j] = tmat[i][j]^1;
        
        if(i-1>=0)
            tmat[i-1][j] = tmat[i-1][j]^1;
        if(j-1>=0)
            tmat[i][j-1] = tmat[i][j-1]^1;
        if(i+1<mat.length)
            tmat[i+1][j] = tmat[i+1][j]^1;
        if(j+1<mat[0].length)
            tmat[i][j+1] = tmat[i][j+1]^1;
            
        //System.out.println(val(tmat));
        return tmat;
    }
}
