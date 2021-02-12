

/*  
https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1/?track=md-string&batchId=144

Given a string without spaces, the task is to remove duplicates from it.
Note: The original order of characters must be kept the same. 

*/

class Solution {
    String removeDups(String s) {
      
         char ch[]=new char[26];
         StringBuilder ans = new StringBuilder();
         for(int i=0;i<s.length();i++){
               char chh = s.charAt(i);
               int p = (int)chh;
               p=p%97;
               if(ch[p]==0){
                   ans.append(chh);
                   ch[p] = 1;
                }
         }
         
         return ans.toString();
    }
}
