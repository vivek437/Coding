/*
https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
*/

class Solution{
    static int equalPartition(int N, int arr[])
    {
         int sum = 0;
         for(int i=0;i<N;i++){
             sum = sum + arr[i];
         }
         int w = sum/2; 

         if(sum%2!=0)
           return 0;
         else{
             int dp[][] = new int [N+1][w+1];
             for(int i=0;i<=N;i++){
                  for(int j=0;j<=w;j++){
                      dp[i][j] = -1;
                  }
             }
             dp[N][w] =  subSetSum(N,arr,w,dp);
             return dp[N][w];
         }
    }
    
     static int subSetSum(int N,int arr[],int w,int dp[][])
     {
          if(N<=0){
               return 0;
          }
          
          if(dp[N-1][w] !=-1)
             return dp[N-1][w];
          
          if(w == 0){
              dp[N-1][w] = 1;
              return 1;
          }
          
          if(w>=arr[N-1]){
              dp[N-1][w] = subSetSum(N-1,arr,w - arr[N-1],dp) | subSetSum(N-1,arr,w,dp);
              return  dp[N-1][w];
          }
          
          else{
             dp[N-1][w] = subSetSum(N-1,arr,w,dp);
             return  dp[N-1][w];
          }
     }
}
