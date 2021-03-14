
/*
https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/?track=md-graph&batchId=144
*/

class Solution
{
    int[][] vis;
    boolean f=false;
    public boolean is_Possible(int[][] grid)
    {
            int si=0,sj=0;
            int n = grid.length;
            vis = new int[n][n];
            for(int i=0;i<n;i++){
                   for(int j=0;j<n;j++){
                       if(grid[i][j]==1){
                          si=i;
                          sj=j;
                       }
                   }
            }
            getPath(grid,si,sj);
            return f;
    }
         
    public void  getPath(int[][] grid,int i,int j)
    {
            vis[i][j] = 1;
            int n = grid.length;
            if(grid[i][j] == 2 || f == true){
                  f = true;
                  return;
            }
                   
            if(i+1<n && j<n && (grid[i+1][j] == 3 || grid[i+1][j] == 2) && vis[i+1][j]==0)   
                  getPath(grid,i+1,j);
            
            if(i-1>=0 && j<n && (grid[i-1][j] == 3 || grid[i-1][j] == 2) && vis[i-1][j]==0)   
                  getPath(grid,i-1,j);      
                   
            if(i<n && j+1<n && (grid[i][j+1] == 3 || grid[i][j+1] == 2) && vis[i][j+1]==0)   
                  getPath(grid,i,j+1);
            
            if(i<n && j-1>=0 && (grid[i][j-1] == 3 || grid[i][j-1] == 2) && vis[i][j-1]==0)   
                  getPath(grid,i,j-1);
        
    }
}

