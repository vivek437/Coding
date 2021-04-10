class Solution 
{
    
    static int eggDrop(int n, int k) 
	{
	   if(n==1)
	    return k;

	   return solve(k,n);

	}
	
    static int solve(int f,int e){
	    
	 int dp[][] = new int[f+1][e+1];
         for(int i=1;i<=e;i++){
             dp[2][i] = 1;
             dp[1][i] = 1;
         }
 
         for(int i=1;i<=f;i++){
             dp[i][1] = 1;
         }
	   
	     for(int i = 2;i <= f ;i++){
	         for(int j = 1;j<= e ;j++){
	               int k = i/2;
	                dp[i][j] = 1 + Math.max(dp[k-1][j],dp[k][j]);
	          }
	     }
	     return dp[f][e];
	}
}
