
//Time Complexity: O(N*M*4^L) where L is the length of the word
//Space Complexity: O(L)

//we dfs and backtracking we mark the cell as visited by using a special character
//we unmark the cell as visited by restoring the original value
//we explore all possible directions using the dirs array
//we return false if no valid path is found


class Solution {
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m=board.length;
        this.n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx){
        if(idx==word.length()) 
            return true;

        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#') 
            return false;

        if(board[i][j]!=word.charAt(idx)) 
            return false;

        //action
        board[i][j]='#';

        //recurse
        for(int[] dir: dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(dfs(board,r,c,word,idx+1)) 
                return true;
        }

        //backtrack
        board[i][j]=word.charAt(idx);

        return false;
    }
}
