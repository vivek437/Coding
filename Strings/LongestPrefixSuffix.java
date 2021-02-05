/* https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/0/ */

class Solution {
    int lps(String s) {
        
       int l=s.length();
       StringBuilder w = new StringBuilder();
       StringBuilder w1 = new StringBuilder();
       int max=0;
       int  p = l-1;
       for(int i=0;i<l-1;i++){
           char ch = s.charAt(i);
           char ch1 = s.charAt(p);
           w.append(ch);
           w1.insert(0, ch1);
           if(w.toString().equals(w1.toString())){
               max = i+1;
           }
           p--;
           
       }  
       return max;
    }
    
}
