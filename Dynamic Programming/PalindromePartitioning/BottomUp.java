
/* 
https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1#
*/
class Solution{
    
    static boolean isPalindrome(String string, int i, int j)
    {
        while(i < j)
        {
          if(string.charAt(i) != string.charAt(j))
             return false; 
          i++;
          j--;
        }
        return true;
    }
    
    static int dp[][];
    static int palindromicPartition(String str)
    {
          int  l = str.length();
          dp = new int[l+1][l+1];
          
          for(int i=0;i<l;i++){
              for(int j=0;j<l;j++){
                  dp[i][j] = -1;
              }
          }
          
          return solve(str,0,l-1);
    }
    
    static int solve(String str,int i,int j){
          
          if(i>j)
            return 0;
          
          if(dp[i][j] !=-1)
             return dp[i][j];
          
          if(isPalindrome(str,i,j) == true){
               dp[i][j] = 0;
               return 0;
          }
          
          int min = Integer.MAX_VALUE; 
          for(int k=i;k<j;k++){
              
            if(dp[i][k]==-1){
                dp[i][k] =   solve(str,i,k);
             }
             
             if(dp[k+1][j]==-1){
                dp[k+1][j] = solve(str,k+1,j);
             }
             
             int temp = 1 + dp[i][k] + dp[k+1][j];
             if(temp<min)
                min = temp;
          }
          
          dp[i][j] = min;
          return dp[i][j];
    }
    
}
