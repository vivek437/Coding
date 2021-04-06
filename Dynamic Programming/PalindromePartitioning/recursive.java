/*
https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
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
  
    static int palindromicPartition(String str)
    {
        
          int  l = str.length();
          return solve(str,0,l-1);
    }
    
    static int solve(String str,int i,int j){
          
          if(i>j)
            return 0;
          
          if(isPalindrome(str,i,j)){
              return 0;
          }
          
          int min = Integer.MAX_VALUE; 
          for(int k=i;k<j;k++){
              
             int temp = 1 + solve(str,i,k)+ solve(str,k+1,j);
             if(temp<min)
                min = temp;
          }
          
          return min;
    }
    
}
