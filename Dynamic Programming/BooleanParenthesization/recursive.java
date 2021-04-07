/*
https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
*/
class Solution{
    static int countWays(int N, String s){
        
      return  solve(s,0,N-1,true);
    }
    
    static int solve(String s,int i, int j, boolean isTrue){
        
        
        if(i>j)
           return 0;
           
        if(i==j){
            
            if(isTrue == true){
                if(s.charAt(i) == 'T')
                  return 1;
                else 
                  return 0;
            }
            else {
                if(s.charAt(i) == 'F')
                  return 1;
                else 
                  return 0;
            }
        }
        
        int ans = 0;
        for(int k = i+1;k<j;k=k+1){
            
            int lT = solve(s,i,k-1,true);
            int rT = solve(s,k+1,j,true);
            int lF = solve(s,i,k-1,false);
            int rF = solve(s,k+1,j,false);
            
            
            if(s.charAt(k) == '&'){
                if(isTrue == true)
                    ans = ans + lT*rT;
                else
                    ans = ans + lT*rF + lF*rT + lF*rF;
            }
            else if(s.charAt(k) == '|'){
                if(isTrue == true)
                    ans = ans + lT*rF + lF*rT + lT*rT;
                else
                    ans = ans + lF*rF;
            }
            else{
                if(isTrue == true)
                    ans = ans + lT*rF + lF*rT ;
                else
                    ans = ans + lF*rF + lT*rT;
            }
        }
        return ans;
    }
}

