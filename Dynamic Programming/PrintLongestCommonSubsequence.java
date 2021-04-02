
/*
https://www.geeksforgeeks.org/printing-longest-common-subsequence/
*/

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        
        int p = s1.length();
        int q = s2.length();
        
         int dp[][] = new int[p+1][q+1];
      
          for(int i=1;i<=p;i++){
             for(int j=1;j<=q;j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1))
                     dp[i][j] = 1 + dp[i-1][j-1];
                else
                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
             }
         }
         
         
         String s = "";
         int i = p, j = q; 
         while(i >0 && j>=0){
             if(s1.charAt(i-1) ==  s2.charAt(j-1)){
                  s = s1.charAt(i-1) + s;
                  i--;
                  j--;
             }
             else if(dp[i-1][j]>dp[i][j-1]) 
                  i--;
             else 
                  j--;
         }
         return s;
    }
}
