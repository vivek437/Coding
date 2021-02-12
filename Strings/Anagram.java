/*   https://practice.geeksforgeeks.org/problems/anagram-1587115620/1/?track=md-string&batchId=144 

Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not.
An anagram of a string is another string that contains the same characters, only the order of characters can be different. 
For example, “act” and “tac” are an anagram of each other.

*/


class Anagram{    
    /*  Function to check if two strings are anagram
    *   a, b: input string
    */
    public static boolean isAnagram(String m,String n)
    {
        char a[] =  m.toCharArray();
        char b[] =  n.toCharArray();
       if(a.length !=b.length)
       return false;
        
        int count[]=new int[26];   
        for(int i=0;i<a.length;i++){
            int ch =(int) a[i];
            int ch1 =(int) b[i];
            ch = ch%97;
            ch1 = ch1%97;
            count[ch] = count[ch] + 1;
            count[ch1] = count[ch1] - 1;
        }
        
        for(int i=0;i<26;i++){
            if(count[i] > 0)
              return false;
        }
        return true;
            
    }
}
