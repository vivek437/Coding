/*  https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1/ */
class Solution {
    public boolean isValid(String s) {

          String w = "";
          if(s.length() > 15)
             return false;
            
          int a[] = new int[15], k=0;
          for(int i=0;i<s.length();i++) {
              
               char ch = s.charAt(i);
               int p = ch - '0';
               if( ch != '.' && (p<0 || p>9))
                   return false;
              
                if( ch != '.' ){
                    k++;
                } 
                
                a[i] = p; 
          }
          
          if(k>3)
             return false;
             
          int c=0, d=0,x=0;
          
          for(int i=0;i<s.length();i++) {
              
              if(a[i]!=-2)
              {
                  if(c==1 && d==0)
                    return false;
                    
                  c++;
                  d=d*10+a[i];
              }
              else{
                  if( d >=  0 && d <=255 && c>=1 && c<=3){
                      c=0;
                      d=0;
                      x++;
                  }
                  else
                    return false;
              }
          }
           if( d >=  0 && d <=255 && c>=1 && c<=3){
                      c=0;
                      d=0;
                      x++;
           }
          if(x == 4)
          return true;
             else 
          return false;
    }
}
