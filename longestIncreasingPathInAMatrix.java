/**
* Given an integer matrix, find the length of the longest increasing path.
*
* From each cell, you can either move to four directions: left, right, up or down.
* You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
* /

class longestIncreasingPathInAMatrix {
    
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length==0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        dp = new int[m][n];
        
        int max = 0;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
               max = Math.max(max,helper(i,j,m,n,dp,matrix)); 
            }
        
        return max;
    }
    
    int helper(int i , int j , int m , int n , int[][] dp , int[][] matrix)
    {
        if(dp[i][j]!=0)
            return dp[i][j];
        
        int max = 1;
        
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j])
            max = Math.max(max,1+helper(i-1,j,m,n,dp,matrix));
        
         if(i+1<m && matrix[i+1][j]>matrix[i][j])
            max = Math.max(max,1+helper(i+1,j,m,n,dp,matrix));
        
        
         if(j-1>=0 && matrix[i][j-1]>matrix[i][j])
            max = Math.max(max,1+helper(i,j-1,m,n,dp,matrix));
        
        
         if(j+1<n && matrix[i][j+1]>matrix[i][j])
            max = Math.max(max,1+helper(i,j+1,m,n,dp,matrix));
        
        dp[i][j] = max;
        
        return dp[i][j];
            
    }
    
}
