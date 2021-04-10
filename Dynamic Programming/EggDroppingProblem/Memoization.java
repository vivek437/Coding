
/*
https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
*/

class Solution 
{
    static int dp[][];
    static int eggDrop(int n, int k) 
	{
	   if(n==1)
	    return k;
	    
	   dp = new int[k+1][n+1];

	   dp[k][n] = solve(k,n);
	   return dp[k][n];
	}
	
    static int solve(int f,int e){
	    
	     if(f <= 0 || e <= 0)
	       return 0;
	       
	     if(f <= 2 ){
	        dp[f][e] = 1;
	        return 1;
	     }

          
	     int x = f/2;
	     int m = 0 ,n = 0;
	     
	     if(dp[f-x-1][e-1] == 0)
            m = solve(f-x-1,e-1);
         if(dp[f-x][e] == 0)
            n = solve(f-x,e);   
              
         m = dp[f-x-1][e-1];
         n = dp[f-x][e];
         
	     dp[f][e] = 1 + Math.max(m,n);
	     return dp[f][e];
	}
}
