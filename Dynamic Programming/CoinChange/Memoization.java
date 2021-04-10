
class Solution
{
    long dp[][];
    public long count(int s[], int m, int n) 
    { 
         dp = new long[m+1][n+1];
         return solve(s,m,n);
    } 
    
    long solve(int[] s,int m,int n){
        
       if( m <= 0)
          return 0;
          
       if( n == 0){
          return 1;
       }
       
       if(dp[m][n]!=0)
         return dp[m][n];
       
       if( n >= s[m-1]){
             dp[m][n] += solve(s,m,n-s[m-1]) + solve(s,m-1,n);
       }
       else{
           dp[m][n] = solve(s,m-1,n);
       }
         return dp[m][n];
    }
}
