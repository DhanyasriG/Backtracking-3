//Time Complexity: O(N*N!)
//Space Complexity: O(N*N)

//approach: backtracking
//Place queens row by row, starting from row 0 (top). For each row, try placing a queen in every column.
//If it's safe (no conflicts in column or diagonals), place the queen.
//If we reach row == N, we found a valid configuration, add to result.
//Backtrack (remove queen) and try other possibilities.


class Solution {
    boolean board[][];
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.board=new boolean[n][n];
        this.result=new ArrayList<>();
        helper(0,n);
        return result;
    }
    private void helper(int r,int n){
        if(r==n){
            //forming the result
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for(int c=0;c<n;c++){
            if(isValid(c,r,n)){
                board[c][r]=true;
                helper(r+1,n);
                board[c][r]=false;  //backtracking
            }
        }
    }
    private boolean isValid(int r,int c,int n){
        int i=r,j=c;
        //row left
        while(j>=0){
            if(board[i][j]) 
                return false;
            j--;
        }

        i=r;j=c;
        //diagonal left up
        while(i>=0&&j>=0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }

        i=r;j=c;
        //diagonal left down
        while(i<n&&j>=0){
            if(board[i][j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}