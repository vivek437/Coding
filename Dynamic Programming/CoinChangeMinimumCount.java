/*
https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
*/
class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	  
	  
	    int dp[][] = new int[M+1][V+1];
	    
	    for(int i=0;i<=M;i++){
	        dp[i][0] = 1;
	    }
	    for(int i=1;i<=V;i++){
	        dp[0][i] = Integer.MAX_VALUE-1;
	    }
	    for(int j=1;j<=V;j++){
	        if(j%coins[0] == 1)
	          dp[1][j] = j/coins[0];
	        else 
	          dp[1][j] = Integer.MAX_VALUE-1;
	    }

	    for(int i=1;i<=M;i++){
	       for(int j=0;j<=V;j++){
	           if(coins[i-1]<=j)
	                dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
	           else
	                dp[i][j] = dp[i-1][j];
	       }
	    }
	    
	   if(dp[M][V] == Integer.MAX_VALUE-1 || dp[M][V] == 0)
	     return -1;
	   else
	    return dp[M][V]-1;
	} 
}
