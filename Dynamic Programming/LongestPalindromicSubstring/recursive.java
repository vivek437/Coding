/*
https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1/?track=md-dp&batchId=144
*/

class Solution{
    String max="";
    String longestPalindrome(String S){
        int l = S.length();
        dp = new int[l+1][l+1];
        solve(S,0,S.length()-1,0,S.length()-1);
        return max;
    }
    
    
    void solve(String s,int p1,int p2,int st,int en) {
        
        if(p1>p2 && (en-st)>max.length() && (en-st)>0){
          max = s.substring(st,en+1); 
        }
        if(p1>s.length()-1 || p2<0 || p1>p2)
           return;
        
        if(s.charAt(p1) == s.charAt(p2))
        {
            solve(s,p1+1,p2-1,st,en);
        }
        solve(s,p1+1,p2,p1+1,p2);
        solve(s,p1,p2-1,p1,p2-1);
     }
}
