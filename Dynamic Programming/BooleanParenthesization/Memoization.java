/*
https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
*/

class Solution{
    static HashMap<String,Integer> hm;
    static int countWays(int N, String s){
       
      hm = new HashMap<String,Integer>(); 
      return  solve(s,0,N-1,true);
      
    }
    
    static int solve(String s,int i, int j, boolean isTrue){
        
        
        if(i>j)
           return 0;
         
        String key = i+ " "+j +" "+ isTrue;
        if(hm.containsKey(key))
            return hm.get(key);
         

        if(i==j){
            
            if(isTrue == true)
                return s.charAt(i) == 'T'? 1 : 0;
            else
                return s.charAt(i) == 'F'? 1 : 0;
        }
        
        
       
        int ans = 0;
        for(int k = i+1;k<j;k=k+2){
            
            int lT = solve(s,i,k-1,true);
            int lF = solve(s,i,k-1,false);
            int rT = solve(s,k+1,j,true);
            int rF = solve(s,k+1,j,false);
            
            
            if(s.charAt(k) == '&'){
                if(isTrue == true)
                    ans = ans + lT*rT;
                else
                    ans = ans + lT*rF + lF*rT + lF*rF;
            }
            else if(s.charAt(k) == '|'){
                if(isTrue == true)
                    ans = ans + (lT*rF) + (lF*rT) + (lT*rT);
                else
                    ans = ans + lF*rF;
            }
            else if(s.charAt(k) == '^'){
                if(isTrue == true)
                    ans = ans + lT*rF + lF*rT ;
                else
                    ans = ans + lF*rF + lT*rT;
            }
        }
        hm.put(key,ans%1003);
         
        return ans%1003;
    }
}
