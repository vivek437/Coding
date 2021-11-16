class Solution {
   int max = 0;

    public int maxIceCream(int[] costs, int coins) {
       
           Arrays.sort(costs);
           int l = costs.length;
           int c = 0 ;
           for(int i=0;i<l;i++){
               if(coins - costs[i]>=0){
                  coins =  coins - costs[i] ;
                   c++;
               }
               if(coins == 0 )
                   break;
           }
           return c;
//         int l = costs.length;
//         int dp[] = new int[coins+1];
//         int dp1[] = new int[coins+1];    
     
//         for(int i = 1;i <= l;i++){
//              dp = new int[dp1.length];
//              for(int j = 1;j<=coins;j++){
//                   dp[j] = dp1[j];
//              }
             
//              for(int j = 1;j<=coins;j++){               
//                  if( j - costs[i-1] >= 0){
//                      dp1[j] =  Math.max( 1 + dp[j-costs[i-1]], dp[j]);
//                  }
//                  else
//                      dp1[j] = dp[j];
//              }         
//         }
//         return dp1[coins];
    }
}