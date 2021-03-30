
/*
https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
*/

class Solution{
    // function to find LCS
    
    
    static int lcs(int p, int q, String s1, String s2){
        
         int dp[][] = new int[p+1][q+1];
       
         
         for(int i=0;i<=p;i++){
             for(int j=0;j<=q;j++){
                 dp[i][j] = -1;
             }
         }
         
         dp[p][q] = formLCS(p,q,s1,s2,dp);
         return dp[p][q];
         
    }
    
    static int formLCS(int p, int q, String s1, String s2,int[][] dp){
        if(p == 0 || q == 0 )
            return  0;
        
        if(dp[p-1][q-1]!=-1)
           return dp[p-1][q-1];
           
        if(s1.charAt(p-1) == s2.charAt(q-1))
             dp[p-1][q-1] = 1 + formLCS(p-1,q-1,s1,s2,dp);
        else
           dp[p-1][q-1] = Math.max(formLCS(p-1,q,s1,s2,dp),formLCS(p,q-1,s1,s2,dp));
           return dp[p-1][q-1];
    }
    
}
