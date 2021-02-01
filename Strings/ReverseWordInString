class Solution {
    String reverseWords(String s) {
    s=s+" ";
    String w="",ans="";
    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch==' '){
         ans = w +ans ; 
           w="";
        }
        if(ch=='.'){
           ans = "."+w+ans ; 
             w="";
        }
        else{
            w=w+ch;
        }
        
    }
    return ans;
    }
}

/// Using String Builder



class Solution {
    String reverseWords(String s) {
    s=s+" ";
    StringBuilder w = new StringBuilder();
    StringBuilder ans = new StringBuilder();
    for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' '){
                ans.insert(0,w);
                w.setLength(0);
            }
            if(ch=='.'){
                ans.insert(0,w);
                ans.insert(0,".");
                w.setLength(0);
            }
            else{
               w.append(ch);
            }
          }
       return ans.toString();
    }
}
