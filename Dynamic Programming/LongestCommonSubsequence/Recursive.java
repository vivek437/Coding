/*
https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
*/

class Solution{
    // function to find LCS
    static int lcs(int p, int q, String s1, String s2){
        
        if(p == 0 || q == 0 )
            return  0;
        
        if(s1.charAt(p-1) == s2.charAt(q-1))
            return 1 + lcs(p-1,q-1,s1,s2);
        
        else
             return Math.max(lcs(p-1,q,s1,s2),lcs(p,q-1,s1,s2));
    }
    
}
