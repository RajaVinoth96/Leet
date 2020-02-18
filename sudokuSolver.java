/**
* Write a program to solve a Sudoku puzzle by filling the empty cells.
*
* A sudoku solution must satisfy all of the following rules:
* 
* Each of the digits 1-9 must occur exactly once in each row.
* Each of the digits 1-9 must occur exactly once in each column.
* Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
* Empty cells are indicated by the character '.'.
*/

class sudokuSolver {
    public void solveSudoku(char[][] board) {
        
       
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    if(board[i][j]=='.')
                    {
                        for(int k=1;k<=9;k++)
                        {
                            if(isSafe(i,j,board,k))
                            {
                            board[i][j] = (char)('0' + k);
                            if(helper(board))
                                return;
                            else
                                board[i][j] = '.';
                            }
                        }
                    }
        
        
    }
    
    boolean helper(char[][] board)
    {
        if(check(board))
            return true;
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(int k=1;k<=9;k++)
                        {
                            if(isSafe(i,j,board,k))
                            {
                            board[i][j] = (char)('0' + k);
                            if(helper(board))
                                return true;
                            else
                                board[i][j] = '.';
                            }
                        }
                    
                    if(board[i][j]=='.')
                        return false;
                }
            }
        }
        
        return false;
    }
    
    
    boolean isSafe(int i , int j , char[][] board, int n)
    {
        for(int k=0;k<9;k++)
        {
            if(board[i][k]!='.' && board[i][k]==(char)('0' + n))
                return false;
            
            if(board[k][j]!='.' && board[k][j]==(char)('0' + n))
                return false;
        }
        
        int r = i - i%3;
        int c = j - j%3;
        
        for(int k=0;k<3;k++)
        {
            for(int l=0;l<3;l++)
            {
                if(board[k+r][l+c]==(char)('0' + n))
                    return false;
            }
        }
        
        return true;
    }
    
    boolean check(char[][] board)
    {
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(board[i][j]=='.')
                    return false;
        
        return true;
    }
}
