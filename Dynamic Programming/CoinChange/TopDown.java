
/*
https://practice.geeksforgeeks.org/problems/coin-change2448/

Max Possible Way
*/
class Solution
{
    public long count(int s[], int m, int n) 
    { 
       
       long dp[][] = new long[m+1][n+1];
       
       for(int i=0;i<=m;i++){
           dp[i][0] = 1;
       }
       
       
       for(int i=1;i<=m;i++){
            
            for(int j=1;j<=n;j++){
                
                if(s[i-1]<=j && (dp[i-1][j]>0 || dp[i][j-s[i-1]]>0)){
                    
                    dp[i][j] = dp[i-1][j] + dp[i][j-s[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
       }

       
         return dp[m][n];
    } 
}
