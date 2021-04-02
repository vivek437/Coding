
/*
https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
*/

class Solution{
    
    static int minimumNumberOfDeletions(String s)
    {
         int n = s.length();
         char[] ch = s.toCharArray();
         int dp[][] = new int[n+1][n+1];
         
         
         int k=n;
         for(int i=1;i<=n;i++){
             k=n;
             for(int j=1;j<=n;j++){
                   if(ch[i-1] == ch[k-1])
                      dp[i][j] = 1 + dp[i-1][j-1];
                   else
                      dp[i][j] = Math.max (dp[i-1][j],dp[i][j-1]);
              k--;
             }
         }
         
         return (n - dp[n][n]); 
    }
}
