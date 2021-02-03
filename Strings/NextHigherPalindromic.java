/* https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/0/?track=md-string&batchId=144# */


class Solution
{
    public String nextPalin(String s) 
    { 
      int l = s.length(),mid=0;
      char oddChar=' ';
      if(l<=3)
        return "-1";
      int oddFlag= 0;
      if(l % 2 == 0)
          mid= l/2-1;
      else{
          mid = l/2;
          oddFlag = 1;
          oddChar = s.charAt(mid);
          mid = mid -1;
       }
         
       int ele = 0 ,pos = 0, f=0, k = mid;
       ele = s.charAt(k) - '0';
       int a[]  = new int[10]; 
       String w ="",ans = "";
       
       for(int j = k-1;j>0;j--){
              char ch = s.charAt(j);
              int p = ch - '0';
              a[ele] = a[ele] +1;
              if(p<ele) {
                   pos = j;
                   f=1;
                   break;
               }
               ele = p;
        } 
        
       if(f==0)
          return "-1";
        
       int exCh = s.charAt(pos) - '0';
       
       int min = 10;
       for(int i=0;i<10;i++){
          
           if(a[i]> 0 && i>exCh && i<min )
             min = i;
       }
        a[min]= a[min]-1;
        a[exCh]=a[exCh]+1;
      
       StringBuilder ak=new StringBuilder();
       for(int i=0;i<10;i++){
          while(a[i]>0){
           ak.append(i);
           a[i]=a[i]-1;
          }
       }
       ans =  s.substring(0,pos) + min + ak.toString() ;
    
       if( oddFlag == 1)
          ans = ans + oddChar +  reverse(ans);
       else
          ans = ans +  reverse(ans) ; 
       return ans;
    }
    
    static String reverse(String s){
        int l = s.length();
        String w="";
        for(int j = 0;j<l;j++){
           w =  s.charAt(j) + w;
        }
        return w;
    }
}

