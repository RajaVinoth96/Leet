/**
* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
* Given an integer n, return all distinct solutions to the n-queens puzzle.
* Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and 
* an empty space respectively.
*/

class nQueens {
    
     List<List<String>> sol;
    
    public List<List<String>> solveNQueens(int n) {
        
        sol = new ArrayList<>();
        
        if(n==0)
            return sol;
        
        int[][] board = new int[n][n];
        
        for(int i=0;i<n;i++)
        {
              board[i][0] = 1;
	          helper(board,1,n);
	          board = new int[n][n];
        }
        
        return sol;
    }
    
    void helper(int[][] board, int j, int n)
    {
       if(j>=n)
	        {
	        	sol.add(help(board,n));
	        	return;
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            if(safe(board,i,j,n))
	            {
	            	board[i][j]=1;
	                helper(board,j+1,n);
	                board[i][j] = 0;
	            }
	            
	        }
	        
	       return;
    }
    
    List<String> help(int[][] board,int n)
    {
        List<String> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            String S = "";
            
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==1)
                    S+='Q';
                else
                    S+='.';
            }
            
            ans.add(S);
        }
        
        return ans;
    }
    
     boolean safe(int[][] board , int row , int col, int n)
	    {
	    	  int i, j; 
	    	  
	         
	          for (i = 0; i < col; i++) 
	              if (board[row][i] == 1) 
	                  return false; 
	    
	         
	          for (i=row, j=col; i>=0 && j>=0; i--, j--) 
	              if (board[i][j] == 1) 
	                  return false; 
	    
	          
	          for (i=row, j=col; j>=0 && i<n; i++, j--) 
	              if (board[i][j] == 1) 
	                  return false; 
	    
	          return true; 
	    }
}
