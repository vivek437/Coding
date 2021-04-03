
/*
https://leetcode.com/problems/shortest-common-supersequence/
*/
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n = str1.length();
        int m = str2.length();
        
        
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(str1.charAt(i-1) == str2.charAt(j-1))
                   dp[i][j] = 1 + dp[i-1][j-1];
                else
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i = n,j = m;
        String s="";
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                s = str2.charAt(j-1) + s;
                i--;
                j--;
            }
            else if (dp[i-1][j]>dp[i][j-1])
                i--;
            else
                j--;
        }
       int k = 0;
       i = 0; j = 0;
       String ans = "";
       while( i<n && j<m && k<dp[n][m])
       {
          if(str1.charAt(i) != s.charAt(k)){              
              ans = ans + str1.charAt(i);
              i++;
              continue;
          }
           
          else if(str2.charAt(j) != s.charAt(k)){
              ans = ans + str2.charAt(j);
              j++;
          }
          else{
              ans = ans + s.charAt(k);
              i++; j++;
              k++;
          }        
       } 
        for(int x = i;x<n;x++){
             ans = ans + str1.charAt(x);
        }
        for(int x = j;x<m;x++){
             ans = ans + str2.charAt(x);
        }
        return ans;
    }
}
