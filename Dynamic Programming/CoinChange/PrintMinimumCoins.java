/*
https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1/?track=md-dp&batchId=144
*/

class Solution{
    static List<Integer> minPartition(int n)
     {
         int[] curr= new int[] { 1, 2, 5, 10, 20,50, 100, 200, 500, 2000 };
         int l = curr.length;
         int[][] dp = new int[l+1][n+1];
         
        
         for(int i=0;i<=n;i++){
            dp[1][i] = i;
         }

         for(int i=0;i<=l;i++){
            dp[i][1] = 1;
         }
       
       
       for(int i=2;i<=l;i++){
            
            for(int j=1;j<=n;j++){
                
                if(curr[i-1]<=j && (dp[i-1][j]>0 && dp[i][j-curr[i-1]]>=0)){
                    
                    dp[i][j] = Math.min(dp[i-1][j] , 1 + dp[i][j-curr[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
       }

        List<Integer> ls = new ArrayList<Integer>();
        int i = l, j = n;
        while(i > 0  && j > 0){
 
            if(j-curr[i-1]>=0){
                if(dp[i-1][j] >= 1 + dp[i][j-curr[i-1]]){
                  ls.add(curr[i-1]);
                  j = j - curr[i-1];
                }
            else        
                i--;
            }
            else 
              i--;
        }
         return ls;
     }
}

