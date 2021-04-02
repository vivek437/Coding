
/*
https://leetcode.com/problems/longest-palindromic-subsequence/
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int l = s.length(); 
        char[] ch =  s.toCharArray();

        int dp[][] = new int[l+1][l+1];
        int  k=l;
        for(int i=1;i<=l;i++){
            k=l;
            for(int j=1;j<=l;j++){
                
                if(ch[i-1] == ch[k-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                k--;
            }            
        }
        
        return dp[l][l];
    }
}
