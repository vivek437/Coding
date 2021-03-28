
/*
https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
*/


class Solution
{
    public int maximizeCuts(int n, int x, int y, int z)
    {
            int a[] = new int[3];
            a[0] = x;
            a[1] = y;
            a[2] = z;
 
           int dp[][] = new int[4][n+1];
            for(int j=0;j<=3;j++){
                dp[j][0] =1;
            }

           for(int i=1;i<=3;i++){
                
                  for(int j=1;j<=n;j++){
                    
                    if(a[i-1]<=j && (dp[i-1][j]> 0 || dp[i][j-a[i-1]]>0)){
                        dp[i][j] =  Math.max(dp[i-1][j], 1 + dp[i][j-a[i-1]]);
                    }
                    else
                        dp[i][j] = dp[i-1][j];
                  }
           }
           
           if(dp[3][n] == 0)
             return 0;
           else
             return (dp[3][n] - 1);
           
    }
}
 
