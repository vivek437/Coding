
/*
https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
*/

public static int shortestCommonSupersequence(String s1, String s2, int n, int m)
{
     
    int dp[][] = new int[n+1][m+1];
    
    for(int i=1;i<=n;i++){
        
         for(int j=1;j<=m;j++){
              
              if(s1.charAt(i-1) == s2.charAt(j-1))
                  dp[i][j] = 1 + dp[i-1][j-1];
               else
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
         }
         
    }
    
    if(m-dp[n][m]>n-dp[n][m])
       return m+(n-dp[n][m]);
    else
       return n+(m-dp[n][m]);
}
