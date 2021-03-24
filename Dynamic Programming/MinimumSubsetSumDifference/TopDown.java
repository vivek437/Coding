
class Solution
{

	public int minDiffernce(int arr[], int n) 
	{ 
	       int sum = 0;
	       for(int i=0;i<n;i++){
	           sum = sum + arr[i];  
	       } 
	       
	       int  w = sum%2 == 0? sum/2 : sum/2+1 ;
	       int dp[][] = new int[n+1][w+1];
	       
	       for(int i=0;i<=w;i++){
	            dp[0][i] = 0;
	       }
	       
	       for(int i=0;i<=n;i++){
	            dp[i][0] = 1;
	       }
	       	          
            for(int i=1;i<=n;i++){
                 for(int j=1;j<=w;j++){
                     if( arr[i-1] <=j )
                        dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i-1]];
                     else
                        dp[i][j] = dp[i-1][j];
                 }
             }
	       
	          int p = 0;
	          for(int i = w;i>0;i--){
	                if(dp[n][i] == 1){
	                    p = 2*i;
	                    break;
	                }	                    
	           }  
    
	           if(p > sum)
	              return p - sum;
	           else
	              return sum - p;

	      }
}
