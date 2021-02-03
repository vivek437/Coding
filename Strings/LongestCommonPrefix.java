/* https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/0/?track=md-string&batchId=144#  */
class Solution{
    String longestCommonPrefix(String arr[], int n){

       StringBuilder w = new StringBuilder(arr[0]);
       StringBuilder w1 = new StringBuilder();
       for(int i=1;i< n;i++){
          
          int l1 = w.length();
          
          int l2 = arr[i].length();
          int l = l1<l2?l1:l2; 
          w1 = new StringBuilder();
          for(int j=0;j<l;j++)
          {
             char ch = arr[i].charAt(j);
             char ch1 = w.charAt(j);
             
             if(ch == ch1){
                 w1.append(ch);
             }
             else
               break;
          }
          
          if (w1.length() == 0)
             return "-1";
          w = w1;
        }
        return w.toString();
    }
}
