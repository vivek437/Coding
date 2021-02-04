/*  https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1

    Using Two Pointer and an array to keep count of characters between current pointers
    
*/

class solve
{
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1" 
    public static String smallestWindow(String s, String P){
       
         char inp[] = s.toCharArray();
         int len = inp.length; 
         int len1 = P.length();
        
         int a[] = new int[26]; 
         int currChar[] = new int[26]; 
         
         for(int i = 0; i< len1;i++){
             int ch = (int) P.charAt(i);
             ch = ch%97;
             a[ch] = a[ch] + 1;
         }

          int st = 0, min = len, i, f=0, c=0;
          String w="";
          
          i=0;
          int minStart = 0,minEnd = 0;
          while(i<len){
              
              int curr = (int)inp[i];
              curr = curr%97;
        
              if(a[curr] > 0 ){
                   if(currChar[curr] < a[curr]){
                      c++;
                  }
                  currChar[curr] = currChar[curr] + 1;
              }
              
             if(c == 1 && f==0) { 
                      f=1;
                      st = i;
             }
              
              while(c == len1 && st<=i && (i-st+1)>=len1){

                  if((i - st)<min && c == len1){
                      min = i - st;
                      minStart = st;
                      minEnd = i+1;
                      
                  }
                 
                  curr = (int)inp[st];
                  curr = curr%97;
                  
                   if(a[curr] > 0 ){
                           if(currChar[curr] <= a[curr]){
                             c--;
                          }
                          currChar[curr] = currChar[curr] - 1;
                    }
                     st++;
              }
              
              if(c == 0)
                  f=0;
              i++;
          }
          
          w = s.substring(minStart,minEnd);
          
          if(w.length()>0)
             return w;
          else 
             return "-1";
    }
}
