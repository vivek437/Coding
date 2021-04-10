
/*
https://www.interviewbit.com/problems/scramble-string/#
*/

public class Solution {
  
    HashMap<String,Integer> hm;
    public int isScramble(final String A, final String B) {
       hm = new HashMap<String,Integer>();
       return solve(A,B);
    }
    public int solve(String A, String B){
         
        if(A.equals(B))
           return 1;
        if(A.length()<=1)
            return 0;
       
        String k = A + " " + B;
        if(hm.containsKey(k))
          return hm.get(k);
        int n = A.length();
        int flag = 0;
        for(int i=1;i<n;i++){
              if((solve(A.substring(0,i),B.substring(n-i,n)) == 1) &&  (solve(A.substring(i,n),B.substring(0,n-i)) == 1) || 
              (solve(A.substring(0,i),B.substring(0,i)) == 1 && solve(A.substring(i,n),B.substring(i,n))==1)){
                    flag = 1;
                    break;
              }
        }
        
        hm.put(k,flag);
        return flag;
    }
}
