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
             for(int i=1;i<=N;i++){
                      dp[i-1][0] = 1;
             }

            for(int i=1;i<=N;i++){
                for(int j=1;j<=w;j++){
                    if(arr[i-1]<=j)
                      dp[i][j] =  dp[i-1][j-arr[i-1]] | dp[i-1][j];
                    else
                       dp[i][j] =   dp[i-1][j];
               }
             }
             return dp[N][w];
         }
    }
}
