/*

https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/0/?track=md-string&batchId=144
Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.

*/
class Rotation{
    
    /*  Function to check if two strings are rotated
    *   s1, s2: input strings
    */
    public static boolean isRotated(String s1, String s2){
        
        // Your code here
        
        if(s1.length() != s2.length())
           return false;
        
        int l=s1.length(); 
        char ch[]=new char[l];
        
        int p = 2,f=0;
        p=p%l;
        for(int i=0;i<l;i++)
        {
            p = p%l;
            if(s2.charAt(i) == s1.charAt(p)){
                p++;
            }
            else{
               f=1;
               break;
            }
        }
        p=2;
        p=p%l;
        if(f==0)
          return true;
        f=0;
        for(int i=0;i<l;i++)
        {
            p = p%l;
            // System.out.println(p);
            if(s1.charAt(i) == s2.charAt(p)){
                p++;
            }
            else{
               f=1;
               return false;
            }
        }
        return true;
    }
    
}
